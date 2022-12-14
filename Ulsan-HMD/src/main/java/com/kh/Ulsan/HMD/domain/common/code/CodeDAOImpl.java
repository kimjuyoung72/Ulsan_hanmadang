package com.kh.Ulsan.HMD.domain.common.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CodeDAOImpl implements CodeDAO{

  private final JdbcTemplate jt;

  @Override
  public List<Code> code(String pcode) {
    StringBuffer sql = new StringBuffer();
    sql.append("select t1.code_id code, t1.decode decode  ");
    sql.append("from code t1, code t2 ");
    sql.append("where t1.pcode_id = t2.code_id  ");
    sql.append("and t1.useyn = 'Y'  ");
    sql.append("and t1.pcode_id = ? ");

    List<Code> codes = jt.query(
            sql.toString(),
            new BeanPropertyRowMapper<>(Code.class),
            pcode
    );
    return codes;
  }

  @Override
  public List<CodeAll> codeAll() {
    StringBuffer sql = new StringBuffer();
    sql.append("select t1.pcode_id pcode, t2.decode pdecode, t1.code_id ccode, t1.decode cdecode  ");
    sql.append("  from code t1, code t2 ");
    sql.append(" where t1.pcode_id = t2.code_id  ");
    sql.append("   and t1.useyn = 'Y' ");

    List<CodeAll> codeAll = jt.query(
            sql.toString(),
            new BeanPropertyRowMapper<>(CodeAll.class)
    );
    return codeAll;
  }
}
