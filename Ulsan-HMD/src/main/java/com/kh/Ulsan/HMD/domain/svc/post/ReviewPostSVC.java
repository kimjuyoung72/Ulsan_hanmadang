package com.kh.Ulsan.HMD.domain.svc.post;

import com.kh.Ulsan.HMD.domain.Review;
import com.kh.Ulsan.HMD.domain.dao.post.PostFilterCondition;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewPostSVC {
  /**
   * 등록
   *
   * @param review 후기 게시물 정보
   * @return 등록건수(아이디)
   */
  Review add(Review review);

  Review add(Review review, List<MultipartFile> files);
  /**
   * 수정
   * @param pid 글번호
   * @param review 후기 게시물 정보
   * @return 수정건수
   */
  int edit(Long pid, Review review);
  int edit(Long pid, Review review, List<MultipartFile> files);
  /**
   * 조회
   * @param pid 글번호
   * @return 후기 게시물 정보
   */
  Review findById(Long pid);

  /**
   * 글삭제
   * @param pid 글번호
   * @return 삭제건수
   */
  int delete(Long pid);

  /**
   * 목록
   * @return 후기글목록
   */
  List<Review> all();
  List<Review> all(int startRec, int endRec);
  /**
   * 검색
   * @param filterCondition 분류,시작레코드번호,종료레코드번호,검색유형,검색어
   * @return
   */
  List<Review> all(PostFilterCondition filterCondition);
  int totalCount();

  int totalCount(PostFilterCondition filterCondition);
}

