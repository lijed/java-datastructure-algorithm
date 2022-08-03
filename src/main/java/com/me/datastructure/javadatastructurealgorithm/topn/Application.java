/*
 * Copyright 2022 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.datastructure.javadatastructurealgorithm.topn;

import java.util.*;

/**
 * 。让你做一个东西，按类去分，每类可以插入商品。然后可以根据商品名，找出每类的top k。
 *
 * @Author: Administrator
 * Created: 2022/6/17
 **/
public class Application {

    private static String[] CATS = {"ELC", "BOOK", "SPORTS", "CARDS"};

    private static Map<String, PriorityQueue<Product>> db = new HashMap<>();

    private static Comparator<Product> productNameComparator = (p1, p2) -> {
        if (p1.getName().compareTo(p2.getName()) > 0) {
            return -1;
        } else if (p1.getName().compareTo(p2.getName()) < 0) {
            return 1;
        } else {
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
           add(createProduct(i));
        }

        db.get( "BOOK").forEach(p-> {
            System.out.println(p);
        });

        System.out.println("==============================");

        getTop("BOOK", 2).forEach(p-> {
            System.out.println(p);
        });
    }

    private static final Random random = new Random();
    private static Product createProduct(int i) {
        Product product = new Product();
        product.setCat(CATS[i%CATS.length]);
        product.setPrice(random.nextDouble());
        product.setName(random.nextInt(100) + CATS[i%CATS.length]);
        product.setPoint(random.nextInt(1000) );
        return product;
    }

    public static void add(Product product) {
        final PriorityQueue<Product> products =
                db.computeIfAbsent(product.getCat(), key -> new PriorityQueue<Product>(productNameComparator));
        products.add(product);
    }

    public static void remove(Product product) {
        final PriorityQueue<Product> products = db.get(product.getCat());
        if (products != null && products.size() > 0) {
            products.remove(product);
        }
    }

    public static List<Product> getTop(String cat, int top) {
        final PriorityQueue<Product> products = db.get(cat);
        List<Product> topList = new ArrayList<>();
        if (products != null && products.size() > 0) {
            for (int i = 0; i < top; i++) {
                final Product product = products.poll();
                if (product != null) {
                    topList.add(product);
                } else {
                    break;
                }
            }
        }
        return topList;
    }


    private static class Product {
        private String cat;
        private String name;
        private Integer point;
        private Double price;

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPoint() {
            return point;
        }

        public void setPoint(Integer point) {
            this.point = point;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "cat='" + cat + '\'' +
                    ", name='" + name + '\'' +
                    ", point=" + point +
                    ", price=" + price +
                    '}';
        }
    }
}
