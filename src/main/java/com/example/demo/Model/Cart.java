package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items;
    private double total;
    public Cart(){
        items= new ArrayList<>();
        total=0;
    }
    public CartItem getItem(Products products){
        for(CartItem item : items){
            if(item.getProduct().getProduct_id()==products.getProduct_id()){
                return item;
            }
        }
        return null;
    }
    public List<CartItem> getItems(){
        return  items;
    }
    public int getItemCount(){
        return items.size();
    }
    public void addItem(CartItem item){
        addItem(item.getProduct(),item.getQuantity());
    }
    public void addItem(Products product ,int quantity){
        CartItem item = getItem(product);
        if(item !=null){
            item.setQuantity(item.getQuantity()+1);
        }
        else{
            item = new CartItem(product);
            item.setQuantity(quantity);
            items.add(item);
        }
    }
    public void  updateItem(Products product,int quantity){
        CartItem item=getItem(product);
        if(item !=null){
            item.setQuantity(quantity);
        }
    }
    public void RemoveItem(Products products){
        CartItem item = getItem(products);
        if(item !=null){
            items.remove(item);
        }
    }
    public void clear(){
        items.clear();
        total=0;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
}
