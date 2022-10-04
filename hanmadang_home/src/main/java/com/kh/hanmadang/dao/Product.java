package com.kh.hanmadang.dao;

public class Product {
    private Long productId;          //    PRODUCT_ID	NUMBER(10,0)
    private String pname;              //    PNAME	VARCHAR2(30 BYTE)
    private Long quantity;            //    QUANTITY	NUMBER(10,0)
    private Long price;                 //    PRICE	NUMBER(10,0)

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
