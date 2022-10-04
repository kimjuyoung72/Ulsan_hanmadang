package com.kh.shopping;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String[] itemName = new String[]{"상추", "부추", "고추", "배추", "양배추"};
        int[] itemPrice = new int[]{1000, 1500, 3000, 3500, 2500};
        Product[] products = new Product[itemName.length];
        Set<Product> itemSet = new TreeSet<>();
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        for (int i = 0; i < itemName.length; i++) {
            products[i] = new Product(itemName[i], itemPrice[i]);
            shoppingBasket.put(products[i]);
        }
        System.out.println(shoppingBasket);

        //가격 내림차순(Comparator)
        Comparator<Product> comparator3 = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                int result = 0;
                if (p1.getItemPrice() > p2.getItemPrice()) {
                    result = -1;
                } else if (p1.getItemPrice() < p2.getItemPrice()) {
                    result = 1;
                }
                return result;

            }
        };
        ShoppingBasket shoppingBasket3 = new ShoppingBasket(comparator3);
        for (int i = 0; i < itemName.length; i++) {
//          products[i] = new Product(itemName[i], itemPrice[i]);
            shoppingBasket3.put(products[i]);
        }
        System.out.println(shoppingBasket3);

        //==================================================
        //상품명 오름차순 비교연산자
        Comparator<Product> comp4 = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        };

        //==================================================
        ShoppingBasket shoppingBasket4 = new ShoppingBasket(comp4);
        for (int i = 0; i < itemName.length; i++) {
            shoppingBasket4.put(products[i]);
        }
        System.out.println(shoppingBasket4);
        //상품명 내림차순 비교연산자
        Comparator<Product> comp5 = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getItemName().compareTo(o2.getItemName()) * -1;
            }
        };

        ShoppingBasket shoppingBasket5 = new ShoppingBasket(comp5);
        for (int i = 0; i < itemName.length; i++) {
            shoppingBasket5.put(products[i]);
        }
        System.out.println(shoppingBasket5);
    }
}
