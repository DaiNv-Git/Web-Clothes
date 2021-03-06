package com.example.demo.Controller;
import com.example.demo.Model.Products;
import com.example.demo.Model.Users;
import com.example.demo.Respository.ProductRpos;
import com.example.demo.Respository.UserRespository;
import com.example.demo.Service.ProductService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    ProductRpos productRpos;
    @Autowired
    ProductService productService;
    @Autowired
    UserRespository userRespository;
    @GetMapping("/product")
    public String getAllProduct(Model model, @Param("keyword") String keyword){
//        List<Products> products = productService.listAll(keyword);
//        model.addAttribute("listproduct",products);
//        model.addAttribute("keyword", keyword);
        return findPaginated(1,model,keyword);
    }
    @GetMapping("delete/{product_id}")
    public String deleteByid(@PathVariable("product_id") int id){
         productRpos.deleteById(id);
        return "redirect:/admin/product";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model){
        Products product = new Products();
        model.addAttribute("add",product);
        return "Admin/new_product";
    }
    //save product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("add") Products products){
        productRpos.save(products);
        return "redirect:/admin/product";
    }
    @GetMapping("edit/{product_id}")
    public ModelAndView EditByid(@PathVariable("product_id") int id){
        ModelAndView mv = new ModelAndView("Admin/edit_product");
        Products product= productRpos.findById(id).get();
        mv.addObject("product",product);
        return mv;
    }
    //pagination
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo")int pageNo,Model model, @Param("keyword") String keyword){
        int pageSize=3;
        Page<Products> page=productService.findPaginated(pageNo,pageSize,keyword);
        List<Products> products= page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalIteams",page.getTotalElements());
        model.addAttribute("listProduct",products);
        model.addAttribute("keyword", keyword);
        return "/Admin/home";
    }
    //User
    @GetMapping("/user")
    public String GetUser(Model model){
            List<Users> user = userRespository.findAll();
            model.addAttribute("user",user);
        return "/Admin/User";
    }
    @GetMapping("deleteUser/{id}")
    public String deleteByidUser(@PathVariable("id") int id){
        userRespository.deleteById(id);
        return "redirect:/admin/user";
    }
    @GetMapping("/500")
    public  String erro500(){
    return "Admin/505";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model){
        Users user = new Users();
        model.addAttribute("user",user);
        return "Admin/Add_User";
    }
    //
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") Users users){
        userRespository.save(users);
        return "redirect:/admin/user";
    }
    @GetMapping("editUser/{id}")
    public ModelAndView EditByidUser(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("Admin/User_Edit");
        Users users= userRespository.findById(id).get();
        mv.addObject("user",users);
        return mv;
    }
}
