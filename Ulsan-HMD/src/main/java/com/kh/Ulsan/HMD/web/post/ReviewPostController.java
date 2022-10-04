package com.kh.Ulsan.HMD.web.post;

import com.kh.Ulsan.HMD.domain.Review;
import com.kh.Ulsan.HMD.domain.common.code.CodeDAO;
import com.kh.Ulsan.HMD.domain.common.file.AttachCode;
import com.kh.Ulsan.HMD.domain.common.file.UploadFile;
import com.kh.Ulsan.HMD.domain.common.file.UploadFileSVC;
import com.kh.Ulsan.HMD.domain.common.paging.FindCriteria;
import com.kh.Ulsan.HMD.domain.dao.post.PostFilterCondition;
import com.kh.Ulsan.HMD.domain.svc.post.ReviewPostSVC;
import com.kh.Ulsan.HMD.web.form.post.review.AddForm;
import com.kh.Ulsan.HMD.web.form.post.review.DetailForm;
import com.kh.Ulsan.HMD.web.form.post.review.EditForm;
import com.kh.Ulsan.HMD.web.form.post.review.ListForm;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("post/reviews")
public class ReviewPostController {

  private final ReviewPostSVC reviewPostSVC;
  private final UploadFileSVC uploadFileSVC;
  private final CodeDAO codeDAO;

  @Autowired
  @Qualifier("fc10") //동일한 타입의 객체가 여러개있을때 빈이름을 명시적으로 지정해서 주입받을때
  private FindCriteria fc;

  //등록화면
  @GetMapping("/add")
  public String addForm(Model model) {

    model.addAttribute("form", new AddForm());
    return "post/review/addForm";
  }
  //등록
  @PostMapping("/add")
  public String add(@Valid @ModelAttribute("form") AddForm addForm,
                    BindingResult bindingResult,
                    HttpSession session) {

    if (bindingResult.hasErrors()) {
      log.info("bindingResult={}", bindingResult);
      return "post/review/addForm";
    }
    //세션 가져오기
//    LoginMember loginInfo = (LoginMember) session.getAttribute(LoginOkConst.LOGIN_MEMBER);
    //세션 정보가 없으면 로그인페이지로 이동
//    if (loginInfo == null) {
//      return "redirect:/login";
//    }

    Review review = new Review();

    BeanUtils.copyProperties(addForm, review);
//    review.setReviewPostWriter(loginInfo.getName());
      review.setReviewPostWriter("김재미");
    Review addedReview = new Review();
    if (!addForm.getFiles().get(0).isEmpty()) {
      addedReview = reviewPostSVC.add(review, addForm.getFiles());
    }else {

      addedReview = reviewPostSVC.add(review);
    }
    return "redirect:/reviews/" + addedReview.getReviewPostId();
  }

  //수정화면
  @GetMapping("/{pid}/edit")
  public String editForm(@PathVariable("pid") Long pid, Model model) {
    Review findedReview = reviewPostSVC.findById(pid);
    EditForm editForm = new EditForm();
    BeanUtils.copyProperties(findedReview, editForm);
    model.addAttribute("form", editForm);

    return "post/review/editForm";
  }
  //수정======================================================================
  @PostMapping("/{pid}/edit")
  public String edit(@Valid @ModelAttribute("form") EditForm editForm,
                     @PathVariable("pid") Long pid,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes) {

    log.info("reviewUpForm={}",editForm);

    if (bindingResult.hasErrors()) {
      log.info("bindingResult={}", bindingResult);
      return "review/editForm";
    }

    Review review = new Review();
    BeanUtils.copyProperties(editForm, review);


    log.info("ruf={}", editForm);

    try {
      if (!editForm.getMpFiles().isEmpty()) {
        reviewPostSVC.edit(pid, review, editForm.getMpFiles());
      }
    } catch (NullPointerException e) {
      reviewPostSVC.edit(pid, review);
    }

//      if (reviewUpForm.getMpFiles() == null || reviewUpForm.getMpFiles().size() == 0) { /////////////////////////////////
//      if (!reviewUpForm.getMpFiles().get(0).isEmpty()) { /////////////////////////////////
//        log.info("file={}", pid);
//        reviewPostSVC.edit(pid, review);
//      }else {
//        log.info("files={}", pid);
//        reviewPostSVC.edit(pid, review, reviewUpForm.getMpFiles());
//
//      }

    redirectAttributes.addAttribute("pid", pid);
    return "redirect:/reviews/{pid}";
  }
  //조회=====================================================================
  @GetMapping("/{pid}")
  public String findById(@PathVariable("pid") Long pid,
                         Model model) {
    Review findedReview = reviewPostSVC.findById(pid);

    DetailForm reviewDetailForm = new DetailForm();
    BeanUtils.copyProperties(findedReview, reviewDetailForm);

    //2-2)상품이미지 조회
    List<UploadFile> uploadFiles = uploadFileSVC.getFilesByCodeWithRid(AttachCode.B0103.name(), pid);
    if(uploadFiles.size() > 0 ){
      List<UploadFile> upFiles = new ArrayList<>();
      for (UploadFile file : uploadFiles) {
        upFiles.add(file);
      }
      reviewDetailForm.setFiles(upFiles);
    }

    model.addAttribute("form", reviewDetailForm);

    return "post/review/detailForm";
  }

  //삭제
  @GetMapping("/{pid}/del")
  public String deleteById(@PathVariable("pid") Long pid) {
    reviewPostSVC.delete(pid);
    return "redirect:/reviews";
  }

  //목록
  @GetMapping
  public String all(Model model) {

    List<Review> list = reviewPostSVC.all();
    log.info("review size={}", list.size());
    model.addAttribute("list", list);
    return "post/review/all";
  }
  //목록
//  @GetMapping
  public String all(
    @PathVariable(required = false) Optional<Integer> reqPage,
    @PathVariable(required = false) Optional<String> searchType,
    @PathVariable(required = false) Optional<String> keyword,
    @RequestParam(required = false) Optional<String> category,
    Model model) {

//    String cate = getCategory(category);
    //FindCriteria 값 설정
    fc.getRc().setReqPage(reqPage.orElse(1)); //요청페이지, 요청없으면 1
    fc.setSearchType(searchType.orElse(""));  //검색유형
    fc.setKeyword(keyword.orElse(""));        //검색어

    List<Review> list = null;
    //게시물 목록


    //검색어 있음
    if (searchType.isPresent() && keyword.isPresent()) {
      PostFilterCondition filterCondition = new PostFilterCondition(
              "", fc.getRc().getStartRec(), fc.getRc().getEndRec(),
              searchType.get(), keyword.get());

      fc.setTotalRec(reviewPostSVC.totalCount());
      fc.setSearchType(searchType.get());
      fc.setKeyword(keyword.get());
      list = reviewPostSVC.all(fc.getRc().getStartRec(), fc.getRc().getEndRec());

    } else {  //검색어 없음
      //총레코드수
      fc.setTotalRec(reviewPostSVC.totalCount());
      list = reviewPostSVC.all(fc.getRc().getStartRec(), fc.getRc().getEndRec());
    }


    List<ListForm> partOfList = new ArrayList<>();
    for (Review review : list) {

      ListForm listForm = new ListForm();
      BeanUtils.copyProperties(review, listForm);
      partOfList.add(listForm);
    }

    model.addAttribute("list", partOfList);
    model.addAttribute("fc", fc);

    return "post/review/allForm";
  }

  //쿼리스트링 카테고리 읽기, 없으면 ""반환
  private String getCategory(Optional<String> category) {
    String cate = category.isPresent()? category.get():"";
    log.info("category={}", cate);
    return cate;
  }
}
