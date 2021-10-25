package com.example.demo.Controller;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Products;
import com.example.demo.Service.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartManager cartManager;
    @PostMapping("/add")
    public String AddtoCart(HttpSession session, @RequestParam("product_id")Products product,
                            @RequestParam(value = "qty",required = false,defaultValue = "1")int qty){
        Cart  cart=cartManager.getCart(session);
        cart.addItem(product,qty);
        return "shopping-cart";
    }
    @RequestMapping("/remove")
    public String Remove(HttpSession session,@RequestParam("product_id") Products product){
        Cart cart = cartManager.getCart(session);
        cart.RemoveItem(product);
        return "shopping-cart";
    }
    @RequestMapping("/update")
    public String Update(HttpSession session,@RequestParam("product_id")Products product,@RequestParam("qty")  int qty){
        Cart cart= cartManager.getCart(session);
        cart.updateItem(product,qty);
        return "shopping-cart";
    }
}
