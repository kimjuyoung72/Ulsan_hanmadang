package com.kh.demo.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor

public class ProductDAOimpl implements ProductDAO{

//    JDBCTemplate은 자동으로 생성된 키 값을 구할 수 있는 방법, KeyHolder 제공
    private final JdbcTemplate jt;

    //등록
    @Override
    public Long save(Product product) {
        StringBuffer sql = new StringBuffer();
//        insert query
        sql.append("insert into product(product_id,pname,quantity,price) ");
        sql.append("     values(product_product_id_seq.nextval, ?, ?, ?) ");
//        1. GeneratedKeyHolder 객체를 생성한다. 이 클래스는 자동 생성된 키 값을 구해주는 KeyHolder 구현 클래스
        KeyHolder keyHolder = new GeneratedKeyHolder();
//        2. update() 메서드는 PreparedStatementCreator 객체와 KeyHolder 객체를 파라미터로 갖는다.
        jt.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//            3. PreparedStatement 객체를 생성하는데 두 번째 파라미터로 String 배열인 ["product_id"]를 주었다.
//            이 두번째 파라미터는 자동 생성되는 키 칼럼 목록을 지정할 때 사용한다. MEMBER 테이블은 ID 칼럼이 auto_increment
//            칼럼이므로 두번째 파라미터 값으로 ID를 준다.
                PreparedStatement pstmt = con.prepareStatement(sql.toString(), new String[]{"product_id"});
//                ?, ?, ? 에 해당하는 값 할당
                pstmt.setString(1, product.getPname());
                pstmt.setLong(2, product.getQuantity());
                pstmt.setLong(3, product.getPrice());
                return pstmt;
            }
//        4. JdbcTemplate.update() 메서드의 두번째 파라미터로 KeyHolder 객체를 전달
        },keyHolder);
//        5. KeyHolder에 보관된 값은 getKey() 메서드를 이용해 구할 수 있다.
        return Long.valueOf(keyHolder.getKeys().get("product_id").toString());
    }

    //목록
    @Override
    public List<Product> findAll() {
        StringBuffer sql = new StringBuffer();
        sql.append("select product_id,pname,quantity,price ");
        sql.append("  from product ");
        sql.append("order by product_id desc ");

        List<Product> products = jt.query(sql.toString(), new BeanPropertyRowMapper<>(Product.class));

        return products;
    }

    //조회
    @Override
    public Product findByProductId(Long productId) {
        StringBuffer sql = new StringBuffer();

        sql.append("select product_id, pname, quantity, price ");
        sql.append("  from product ");
        sql.append(" where product_id = ? ");

        Product product = null;
        try {
            product = jt.queryForObject(
                    sql.toString(),
                    new BeanPropertyRowMapper<>(Product.class),
                    productId);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }
        return product;
    }

    //변경
    @Override
    public int update(Long productId, Product product) {

        StringBuffer sql = new StringBuffer();
        sql.append("update product ");
        sql.append("   set pname = ?, ");
        sql.append("       quantity = ?, ");
        sql.append("       price = ? ");
        sql.append(" where product_id = ? ");

        int affectedRow = jt.update(sql.toString(),
                product.getPname(), product.getQuantity(), product.getPrice(),productId);
        return affectedRow;
    }

    //삭제
    @Override
    public int deleteByProductId(Long productId) {

        String sql = "delete from product where product_id = ? ";

        int affectedRow = jt.update(sql.toString(), productId);

        return affectedRow;
    }
}
