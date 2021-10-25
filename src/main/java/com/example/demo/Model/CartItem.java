package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class CartItem {
    private final   Products product;
    private  int quantity;
    private  double subTotal;
    public CartItem(Products product){
        this.product = product;
        this.quantity=1;
        this.subTotal=product.getPrice();
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotal() {
        subTotal= product.getPrice()*quantity;
        return subTotal;
    }





    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
