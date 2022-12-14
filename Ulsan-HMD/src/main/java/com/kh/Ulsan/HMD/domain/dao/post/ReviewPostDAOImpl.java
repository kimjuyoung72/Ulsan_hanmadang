package com.kh.Ulsan.HMD.domain.dao.post;

import com.kh.Ulsan.HMD.domain.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.List;


@Slf4j
@Repository
@RequiredArgsConstructor
public class ReviewPostDAOImpl implements ReviewPostDAO{

  private final JdbcTemplate jt;

  @Override
  public int add(Review review) {
    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("insert into review(review_from_id,review_post_id,review_post_title,review_post_link,review_post_content,review_post_writer,review_post_good) ");
    sql.append("values(?,?,?,?,?,?,?) ");

    result = jt.update(sql.toString(), review.getReviewFromId(), review.getReviewPostId(),
            review.getReviewPostTitle(), review.getReviewPostLink(),review.getReviewPostContent(),
            review.getReviewPostWriter(), review.getReviewPostGood());

    return result;
  }

  @Override
  public int edit(Long pid, Review review) {
    int result = 0;
    StringBuffer sql = new StringBuffer();
    sql.append("update review ");
    sql.append("   set review_post_title = ?, ");
    sql.append("       review_post_content = ?, ");
    sql.append("       udate = systimestamp ");
    sql.append(" where review_post_id = ? ");
//    sql.append("   and pw = ? ");

    result = jt.update(sql.toString(), review.getReviewPostTitle(), review.getReviewPostContent(), pid);
    return result;
  }

  @Override
  public Review findByPostId(Long pid) {
    StringBuffer sql = new StringBuffer();

    sql.append("select review_from_id, ");
    sql.append("       review_post_id, ");
    sql.append("       review_post_title, ");
    sql.append("       review_post_link, ");
    sql.append("       review_post_content, ");
    sql.append("       review_post_writer, ");
    sql.append("       cdate, ");
    sql.append("       udate, ");
    sql.append("       review_post_good ");
//    sql.append("select * ");
    sql.append("  from review ");
    sql.append(" where review_post_id = ? ");

//    private String reviewFromId;            //?????? ?????? ID
//    private Long reviewPostId;            //????????? ID
//    private String reviewPostTitle;         //??????
//    private String reviewPostLink;          //??????????????? ??????
//    private StringBuffer reviewPostContent; //??????
//    private String reviewPostWriter;        //?????????
//    private LocalDateTime cdate;            //?????????
//    private LocalDateTime udate;            //?????????
//    private Integer reviewPostGood;         //????????? -_-)b

    Review findedReview = null;
    try {
      //BeanPropertyRowMapper??? ???????????? ?????????????????? ?????????????????? ??????!
      findedReview = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Review.class), pid);

    } catch (DataAccessException e) {
      log.info("??????????????? ????????? ????????????!={}",pid);
    }
    return findedReview;
  }

  @Override
  public int delete(Long pid) {
    int result = 0;
    String sql = "delete from review where review_post_id = ? ";

    result = jt.update(sql, pid);
    return result;
  }

  @Override
  public List<Review> all() {
    StringBuffer sql = new StringBuffer();

    sql.append("select ");
    sql.append("  review_post_id, ");
    sql.append("  review_post_title, ");
    sql.append("  review_post_link, ");
    sql.append("  review_post_content, ");
    sql.append("  review_post_writer, ");
    sql.append("  review_post_good ");
    sql.append("  from " );
    sql.append("  review ");
    sql.append("order by review_post_id desc ");

    List<Review> result = jt.query(sql.toString(),new BeanPropertyRowMapper<>(Review.class));

    return result;
  }

  @Override
  public List<Review> all(int startRec, int endRec) {
    StringBuffer sql = new StringBuffer();

    sql.append("select t1.* ");
    sql.append("  from( ");
    sql.append("    select ");
    sql.append("    row_number() over (order by review_post_id desc) no, ");
    sql.append("    review_post_id, ");
    sql.append("    review_post_title, ");
    sql.append("    review_post_link, ");
    sql.append("    review_post_content, ");
    sql.append("    review_post_writer, ");
    sql.append("    review_post_good ");
    sql.append("    from " );
    sql.append("    review) t1 ");
    sql.append(" where t1.no between ? and ? ");

    List<Review> list = jt.query(
            sql.toString(),
            new BeanPropertyRowMapper<>(Review.class),
            startRec, endRec);
    return list;
  }

  @Override
  public List<Review> all(PostFilterCondition filterCondition) {

    StringBuffer sql = new StringBuffer();

    sql.append("select t1.* ");
    sql.append("  from( ");
    sql.append("    select ");
    sql.append("    row_number() over (order by review_post_id desc) no, ");
    sql.append("    review_post_id, ");
    sql.append("    review_post_title, ");
    sql.append("    review_post_link, ");
    sql.append("    review_post_content, ");
    sql.append("    review_post_writer, ");
    sql.append("    review_post_good ");
    sql.append("    from " );
    sql.append("    review ");
    sql.append("    where ");
    sql = dynamicQuery(filterCondition, sql);
    sql.append(") t1 ");
    sql.append(" where t1.no between ? and ? ");

    List<Review> list = null;

    //????????? ??????
    if (StringUtils.isEmpty(filterCondition.getCategory())) {
      list = jt.query(
        sql.toString(),
        new BeanPropertyRowMapper<>(Review.class),
        filterCondition.getStartRec(),
        filterCondition.getEndRec()
      );
    }else {

    }

    return list;
  }

  @Override
  public Long generateReviewId() {
    String sql = "select review_review_post_id_seq.nextval from dual ";
    Long reviewPostId = jt.queryForObject(sql, Long.class);
    return reviewPostId;

  }

  @Override
  public int increaseHitCount(Long id) {
    return 0;
  }

  @Override
  public int totalCount() {
    String sql = "select count(*) from review ";

    Integer cnt = jt.queryForObject(sql, Integer.class);

    return cnt;
  }

  @Override
  public int totalCount(PostFilterCondition filterCondition) {
    StringBuffer sql = new StringBuffer();

    sql.append("select count(*) ");
    sql.append("  from review ");
    sql.append(" where  ");

    sql = dynamicQuery(filterCondition, sql);

    Integer cnt = 0;
    //????????? ?????? ?????? ??????
    if(StringUtils.isEmpty(filterCondition.getCategory())) {
      cnt = jt.queryForObject(
              sql.toString(), Integer.class
      );
      //????????? ????????? ?????? ??????
    }else{
      cnt = jt.queryForObject(
              sql.toString(), Integer.class,
              filterCondition.getCategory()
      );
    }

    return cnt;
  }

  private StringBuffer dynamicQuery(PostFilterCondition filterCondition, StringBuffer sql) {
    //??????
    if(StringUtils.isEmpty(filterCondition.getCategory())){

    }else{
      sql.append("       bcategory = ? ");
    }

    //??????,????????????,????????? ??????
    if(!StringUtils.isEmpty(filterCondition.getCategory()) &&
            !StringUtils.isEmpty(filterCondition.getSearchType()) &&
            !StringUtils.isEmpty(filterCondition.getKeyword())){

      sql.append(" AND ");
    }

    //????????????
    switch (filterCondition.getSearchType()){
      case "TC":  //?????? + ??????
        sql.append("    (  title    like '%"+ filterCondition.getKeyword()+"%' ");
        sql.append("    or bcontent like '%"+ filterCondition.getKeyword()+"%' )");
        break;
      case "T":   //??????
        sql.append("       title    like '%"+ filterCondition.getKeyword()+"%' ");
        break;
      case "C":   //??????
        sql.append("       bcontent like '%"+ filterCondition.getKeyword()+"%' ");
        break;
      case "E":   //?????????(?????????)
        sql.append("       email    like '%"+ filterCondition.getKeyword()+"%' ");
        break;
      case "N":   //??????
        sql.append("       nickname like '%"+ filterCondition.getKeyword()+"%' ");
        break;
      default:
    }
    return sql;
  }
}
