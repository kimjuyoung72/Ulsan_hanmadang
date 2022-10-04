package com.kh.Ulsan_Hanmadang.web;

import com.kh.Ulsan_Hanmadang.domain.EventInfo;
import com.kh.Ulsan_Hanmadang.domain.FacInfo;
import com.kh.Ulsan_Hanmadang.domain.common.code.CodeDAO;
import com.kh.Ulsan_Hanmadang.domain.common.file.UploadFile;
import com.kh.Ulsan_Hanmadang.domain.common.file.svc.UploadFileSVC;
import com.kh.Ulsan_Hanmadang.domain.common.paging.FindCriteria;
import com.kh.Ulsan_Hanmadang.domain.post.dao.Post;
import com.kh.Ulsan_Hanmadang.domain.post.dao.PostFilterCondition;
import com.kh.Ulsan_Hanmadang.domain.post.svc.PostSVC;
import com.kh.Ulsan_Hanmadang.web.form.post.*;
import com.kh.Ulsan_Hanmadang.web.session.LoginMember;
import com.kh.Ulsan_Hanmadang.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
  private final PostSVC postSVC;
  private final CodeDAO codeDAO;
  private final UploadFileSVC uploadFileSVC;

  @Autowired
  @Qualifier("fc10") //동일한 타입의 객체가 여러개있을때 빈이름을 명시적으로 지정해서 주입받을때
  private FindCriteria fc;

  //게시판 코드,디코드 가져오기
  @ModelAttribute("classifier")
  public List<Code> classifier(){
    return codeDAO.code("B01");
  }

  @ModelAttribute("postTitle")
  public Map<String,String> bbsTitle(){
    List<Code> codes = codeDAO.code("B01");
    Map<String,String> btitle = new HashMap<>();
    for (Code code : codes) {
      btitle.put(code.getCode(), code.getDecode());
    }
    return btitle;
  }

  //작성양식
  @GetMapping("/add")
//  public String addForm(Model model) {
//    model.addAttribute("addForm", new AddForm());
//    return "bbs/addForm";
//  }
  public String addForm(
          Model model,
          @RequestParam(required = false) Optional<String> category,
          HttpSession session) {

    String cate = getCategory(category);

    LoginMember loginMember = (LoginMember)session.getAttribute(SessionConst.LOGIN_MEMBER);

    AddForm addForm = new AddForm();
    addForm.setEmail(loginMember.getEmail());
    addForm.setNickname(loginMember.getNickname());
    model.addAttribute("addForm", addForm);
    model.addAttribute("category", cate);

    return "post/addForm";
  }

  //작성처리
  @PostMapping("/add")
  public String add(
          //@Valid
          @ModelAttribute AddForm addForm,
          @RequestParam(required = false) Optional<String> category,
          BindingResult bindingResult,      // 폼객체에 바인딩될때 오류내용이 저장되는 객체
          HttpSession session,
          RedirectAttributes redirectAttributes) throws IOException {
    log.info("addForm={}",addForm);

    if(bindingResult.hasErrors()){
      log.info("add/bindingResult={}",bindingResult);
      return "post/addForm";
    }

    String cate = getCategory(category);

    Post post = new Post();
    BeanUtils.copyProperties(addForm, post);

    //세션 가져오기
    LoginMember loginMember = (LoginMember)session.getAttribute(SessionConst.LOGIN_MEMBER);
    //세션 정보가 없으면 로그인페이지로 이동
    if(loginMember == null){
      return "redirect:/login";
    }

    //세션에서 이메일,별칭가져오기
    post.setEmail(loginMember.getEmail());
    post.setNickname(loginMember.getNickname());


    Long originId = 0l;
    //파일첨부유무
    if(addForm.getFiles().size() == 0) {
      originId = postSVC.saveOrigin(post);
    }else{
      originId = postSVC.saveOrigin(post, addForm.getFiles());
    }
    redirectAttributes.addAttribute("id", originId);
    redirectAttributes.addAttribute("category",cate);
    // <=서버응답 302 get http://서버:port/bbs/10
    // =>클라이언트요청 get http://서버:port/bbs/10
    return "redirect:/post/{id}";
  }

  @GetMapping({"/list",
          "/list/{reqPage}",
          "/list/{reqPage}//",
          "/list/{reqPage}/{searchType}/{keyword}"})
  public String listAndReqPage(
          @PathVariable(required = false) Optional<Integer> reqPage,
          @PathVariable(required = false) Optional<String> searchType,
          @PathVariable(required = false) Optional<String> keyword,
          @RequestParam(required = false) Optional<String> category,
          Model model) {

    String cate = getCategory(category);

    //FindCriteria 값 설정
    fc.getRc().setReqPage(reqPage.orElse(1)); //요청페이지, 요청없으면 1
    fc.setSearchType(searchType.orElse(""));  //검색유형
    fc.setKeyword(keyword.orElse(""));        //검색어

    List<Post> list = null;
    List<EventInfo> eList = null;

    //카테고리별 목록
    //검색어 있음
    if(searchType.isPresent() && keyword.isPresent()){
      if(cate.equals("B0101")) {
        PostFilterCondition filterCondition = new PostFilterCondition(
                "B0101", fc.getRc().getStartRec(), fc.getRc().getEndRec(),
                searchType.get(),
                keyword.get());
        fc.setTotalRec(postSVC.totalPEventCount());
        fc.setSearchType(searchType.get());
        fc.setKeyword(keyword.get());
        eList = postSVC.findAllEvents(filterCondition);
      }else {
        PostFilterCondition filterCondition = new PostFilterCondition(
                category.get(), fc.getRc().getStartRec(), fc.getRc().getEndRec(),
                searchType.get(),
                keyword.get());
        fc.setTotalRec(postSVC.totalCount(filterCondition));
        fc.setSearchType(searchType.get());
        fc.setKeyword(keyword.get());
        list = postSVC.findAll(filterCondition);
      }
      //검색어 없음
    }else {
      if(cate.equals("B0101")){
        fc.setTotalRec(postSVC.totalPEventCount());
        eList = postSVC.findAllEvents(fc.getRc().getStartRec(), fc.getRc().getEndRec());
        log.info("findec Evt={}", eList.size());
      }else {
        fc.setTotalRec(postSVC.totalCount(cate));
        list = postSVC.findAll(cate, fc.getRc().getStartRec(), fc.getRc().getEndRec());
      }
    }

    List<EventInfoForm> partOfEventList = new ArrayList<>();
    List<ListForm> partOfList = new ArrayList<>();
    if(cate.equals("B0101")){

      for (EventInfo event : eList) {
        EventInfoForm infoForm = new EventInfoForm();
        BeanUtils.copyProperties(event, infoForm);
        partOfEventList.add(infoForm);
      }
      log.info("plist={}", partOfList.size());
    }else {

      for (Post post : list) {
        ListForm listForm = new ListForm();
        BeanUtils.copyProperties(post, listForm);
        partOfList.add(listForm);
      }
    }

//    log.info("list size={}", partOfList.size());
    if (cate.equals("B0101")) {
      model.addAttribute("list", partOfEventList);
    } else {
      model.addAttribute("list", partOfList);
    }

    model.addAttribute("fc",fc);
    model.addAttribute("category", cate);

    return "post/list";
  }

  //조회
  @GetMapping("/{id}")
  public String detail(
          @PathVariable Long id,
          @RequestParam(required = false) Optional<String> category,
          Model model) {

    String cate = getCategory(category);

    if (cate.equals("B0101")) {
      EventInfo eventInfo = postSVC.findByEventId(id);
      EventInfoForm eventInfoForm = new EventInfoForm();
      BeanUtils.copyProperties(eventInfo, eventInfoForm);


      model.addAttribute("event", eventInfoForm);
      model.addAttribute("category", cate);

      return "post/eventDetailForm";
    }else {
      Post detailPost = postSVC.findByPostId(id);
      DetailForm detailForm = new DetailForm();
      BeanUtils.copyProperties(detailPost, detailForm);
      model.addAttribute("detailForm", detailForm);
      model.addAttribute("category", cate);

      //첨부조회
      List<UploadFile> attachFiles = uploadFileSVC.getFilesByCodeWithRid(detailPost.getPcategory(), detailPost.getPostId());
      if (attachFiles.size() > 0) {
        log.info("attachFiles={}", attachFiles);
        model.addAttribute("attachFiles", attachFiles);
      }

      return "post/detailForm";
    }
  }

  @GetMapping("/fac/{id}")
  public String facInfoForm(
          @PathVariable String id,
          Model model){
    FacInfo findedFac = postSVC.findByFacId(id);
    log.info("ffacnm={}", findedFac.getFcltynm());
    FacInfoForm facInfoForm = new FacInfoForm();
    BeanUtils.copyProperties(findedFac, facInfoForm);
    log.info("facnm={}", facInfoForm.getFcltynm());
    model.addAttribute("info", facInfoForm);

    return "post/facInfoForm";
  }
  //삭제
  @GetMapping("/{id}/del")
  public String del(
          @PathVariable Long id,
          @RequestParam(required = false) Optional<String> category) {

    postSVC.deleteByPostId(id);
    String cate = getCategory(category);
    return "redirect:/post/list?category="+cate;
  }

  //수정양식
  @GetMapping("/{id}/edit")
  public String editForm(
          @PathVariable Long id,
          @RequestParam(required = false) Optional<String> category,
          Model model){
    String cate = getCategory(category);
    Post post = postSVC.findByPostId(id);

    EditForm editForm = new EditForm();
    BeanUtils.copyProperties(post,editForm);
    model.addAttribute("editForm", editForm);
    model.addAttribute("category",cate);

    //첨부조회
    List<UploadFile> attachFiles = uploadFileSVC.getFilesByCodeWithRid(post.getPcategory(), post.getPostId());
    if(attachFiles.size() > 0){
      log.info("attachFiles={}",attachFiles);
      model.addAttribute("attachFiles", attachFiles);
    }

    return "post/editForm";
  }

  //수정처리
  @PostMapping("/{id}/edit")
  public String edit(
          @PathVariable Long id,
          @RequestParam(required = false) Optional<String> category,
          @Valid @ModelAttribute EditForm editForm,
          BindingResult bindingResult,
          RedirectAttributes redirectAttributes
  ) {

    if(bindingResult.hasErrors()){
      return "post/editForm";
    }

    String cate = getCategory(category);
    Post post = new Post();
    BeanUtils.copyProperties(editForm, post);
    postSVC.updateByPostId(id, post);

    if(editForm.getFiles().size() == 0) {
      postSVC.updateByPostId(id, post);
    }else{
      postSVC.updateByPostId(id, post, editForm.getFiles());
    }
    redirectAttributes.addAttribute("id",id);
    redirectAttributes.addAttribute("category", cate);

    return "redirect:/post/{id}";
  }

  //전체 검색
  @GetMapping("/list/search/all")
  public String searchResultForm() {


    return null;
  }

  //답글작성양식
  @GetMapping("/{id}/reply")
  public String replyForm(@PathVariable Long id,
                          @RequestParam(required = false) Optional<String> category,
                          Model model,HttpSession session) {

    String cate = getCategory(category);

    Post parentPost = postSVC.findByPostId(id);
    ReplyForm replyForm = new ReplyForm();
    replyForm.setBcategory(parentPost.getPcategory());
    replyForm.setTitle("답글:"+parentPost.getTitle());

    //세션에서 로그인정보 가져오기
    LoginMember loginMember = (LoginMember)session.getAttribute(SessionConst.LOGIN_MEMBER);
    replyForm.setEmail(loginMember.getEmail());
    replyForm.setNickname(loginMember.getNickname());

    model.addAttribute("replyForm", replyForm);
    model.addAttribute("category", cate);
    return "post/replyForm";
  }

  //답글작성처리
  @PostMapping("/{id}/reply")
  public String reply(
          @PathVariable Long id,      //부모글의 bbsId
          @RequestParam(required = false) Optional<String> category,
          @Valid @ModelAttribute ReplyForm replyForm,
          BindingResult bindingResult,
          RedirectAttributes redirectAttributes
  ){
    if(bindingResult.hasErrors()){
      return "post/replyForm";
    }
    String cate = getCategory(category);
    Post replyPost = new Post();
    BeanUtils.copyProperties(replyForm, replyPost);

    //부모글의 bcategory,bbsId,bgroup,step,bindent 참조
    appendInfoOfParentBbs(id, replyPost);

    //답글저장(return 답글번호)
    Long replyBbsId = 0L;

    if(replyForm.getFiles().size() == 0) {
      replyBbsId = postSVC.saveReply(id, replyPost);

    }else{
      replyBbsId = postSVC.saveReply(id, replyPost, replyForm.getFiles());
    }
    redirectAttributes.addAttribute("id",replyBbsId);
    redirectAttributes.addAttribute("category", cate);
    return "redirect:/bbs/{id}";
  }

  //부모글의 bbsId,bgroup,step,bindent
  private void appendInfoOfParentBbs(Long parentPostId, Post replyPost) {
    Post parentPost = postSVC.findByPostId(parentPostId);
    replyPost.setPcategory(parentPost.getPcategory());
    replyPost.setPostId(parentPost.getPostId());
    replyPost.setPgroup(parentPost.getPgroup());
    replyPost.setStep(parentPost.getStep());
    replyPost.setPindent(parentPost.getPindent());
  }

  //쿼리스트링 카테고리 읽기, 없으면 ""반환
  public String getCategory(Optional<String> category) {
    String cate = category.isPresent()? category.get():"";
    log.info("category={}", cate);
    return cate;
  }

  //공연장 정보 링크
  private String getFacilityLink(String facId) {
    String link = null;


    return link;
  }
}
