package com.example.demo.Service;

import com.example.demo.Model.Cart;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CartManager {
    private static  final  String  Session_Key_GioHang="gioHang";
    public Cart getCart(HttpSession session){
        Cart cart=(Cart)session.getAttribute(Session_Key_GioHang);
        if(cart==null){
            cart = new Cart();
            setCart(session,cart);
        }
        return cart;
    }
    public void setCart(HttpSession session,Cart cart){
        session.setAttribute(Session_Key_GioHang,cart);
    }
    public void removeCart(HttpSession session){
        session.removeAttribute(Session_Key_GioHang);
    }
}
