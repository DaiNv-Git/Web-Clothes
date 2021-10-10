package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Model.Category;
import com.example.demo.Respository.CategoryRepos;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Products;
import com.example.demo.Model.Roles;
import com.example.demo.Model.Users;
import com.example.demo.Respository.ProductRpos;
import com.example.demo.Respository.RoleRepository;
import com.example.demo.Respository.UserRespository;
import com.example.demo.Service.ProductService;

@Controller
public class HomeController {
	@Autowired
	JavaMailSender javamail;
	@Autowired
	private ProductRpos productRpos;
	@Autowired
	private ProductService prService;
	@Autowired
	private UserRespository userRespo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private CategoryRepos categoryRepos;
	@Autowired
	private ProductService productService;
	@RequestMapping("/")
	public String ShowIndex(Model model) {
		List<Products> products = productRpos.getAllByNam("Nam");
		model.addAttribute("nam",products);
		List<Products> productsNu = productRpos.getAllByNam("Nu");
		model.addAttribute("nu",productsNu);
		return "index";
	}
	@GetMapping("product")
	public String getAllProduct(Model model, @Param("keyword") String keyword) {
		List<Products> product =productService.listAll(keyword);
		model.addAttribute("product", product);
		//search
		model.addAttribute("keyword", keyword);
		List<Category> categories =categoryRepos.findAll();
		model.addAttribute("cate",categories);
		return "shop";
	}
	@RequestMapping("detail/{product_id}")
	public String getProductByid(@PathVariable("product_id") int product_id,Model model) {
		Products product = productRpos.findById(product_id).get();
		model.addAttribute("detail",product);
		return "product";
	}

	@RequestMapping("/blog")
	public String blog() {
		return "blog";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("register")
	public String Registor(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return"register";
	}
	@PostMapping("/save")
	public String SaveRegistor(@ModelAttribute("user") Users user,@RequestParam("email")String to,String subject, String message) {

		Users _user = userRespo.findByUserName(user.getUserName());
		if(_user==null) {
			
			Roles role = roleRepo.findByName("Customer");
			user.getRoles().add(role);
			userRespo.save(user);
		}
		else {
			String mess="tai khoan da ton tai";
			return"redirect:/register";
		}
			SimpleMailMessage msg =new SimpleMailMessage();
			 subject = "Sun notification";
			 message="Congratulations, you have successfully registered an account";
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(message);
			javamail.send(msg);
		return"redirect:/login";
	}
	@GetMapping("login")
	public String Login(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return"login";
	}
	@GetMapping("/403")
	public String error403() {
		return"403";
	}
}
