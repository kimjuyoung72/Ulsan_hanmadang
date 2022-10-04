package com.kh.Ulsan.HMD.domain.common.code;

import java.util.List;

public interface CodeDAO {

  /**
   * 상위코드를 입력하면 하위코드 반환
   * @param pcode 상위코드
   * @return  하위코드
   */
  List<Code> code(String pcode);

  List<CodeAll> codeAll();
}
