package com.kh.Ulsan_Hanmadang.domain.member.dao;

import com.kh.Ulsan_Hanmadang.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDAO {

  /**
   * 가입
   * @param member 가입정보
   * @return 가입건수
   */
  Member insert(Member member);

  /**
   * 조회 by 회원아이디
   * @param email 회원아이디
   * @return 회원정보
   */
  Member findMemberByEmail(String email);

  //조회 by member_id
  Member findMemberById(Long member_id);


  /**
   * 수정
   * @param member  수정할 정보
   */
  void update(Member member);

  /**
   * 패스워드 확인
   * @param email 회원 아이디
   * @param password 입력할 비밀번호
   * @return
   */
  boolean isMember(String email, String password);

  /**
   * 탈퇴
   * @param email 아이디
   */
  void del(String email);

  /**
   * 신규 회원아이디(내부관리용) 생성
   * @return 회원아이디
   */
  Long generateId();

  /**
   * 비밀번호 체크
   * @param email
   * @param password
   * @return
   */
  boolean isPassword(String email, String password);

  /**
   * 이메일 중복체크
   * @param email 이메일
   * @return 존재하면 true
   */
  Boolean dupChkOfMemberEmail(String email);


  /**
   * 닉네임 중복체크
   * @param nickname 닉네임
   * @return 존재하면 true
   */
  Boolean dupChkOfMemberNickname(String nickname);

  /**
   * 로그인
   * @param email 이메일
   * @param password  비밀번호
   * @return  회원
   */
  Optional<Member> login(String email, String password);

  /**
   * 아이디 찾기
   * @param nickname 찾을 회원의 닉네임
   * @return
   */
  String findMyEmail(String nickname);

  /**
   * 비밀번호 찾기
   * @param email 찾을 회원의 이메일
   * @return
   */
  String findMyPassword(String email);



  //전체조회
  List<Member> selectAll();


  //회원유무체크
  boolean exitMember(String email);

}

