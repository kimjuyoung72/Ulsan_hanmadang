package com.kh.shopping;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private String itemName;
    private int itemPrice;

    public Product() {
    }

    public Product(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "[ " +
                "상품명 : " + itemName  +
                ", 가격 : " + itemPrice +
                " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return itemPrice == product.itemPrice && Objects.equals(itemName, product.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemPrice);
    }


    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public int compareTo(Product o) {
        int result = 0;

        if (this.itemPrice < o.itemPrice) { //오름차순
            return result = -1;
        } else if (o.itemPrice < this.itemPrice) {
            return result = 1;
        }
//        if (this.itemPrice > o.itemPrice) { //오름차순
//            return result = 1;
//        } else if (o.itemPrice > this.itemPrice) {
//            return result = -1;
//        }

        return result;
    }

}
