package com.example.joe.myrestaurent;

/**
 * Created by Joe on 09/01/2017.
 */

public class ProductContent {

    int productID;
    String productName;
    String productPrice;
    int productPhoto;

    public ProductContent() {
    }

    public ProductContent(String productName, String productPrice, int productPhoto) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.productPhoto = productPhoto;
    }
}
