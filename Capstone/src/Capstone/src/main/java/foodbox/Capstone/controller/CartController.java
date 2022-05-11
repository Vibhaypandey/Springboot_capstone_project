package foodbox.Capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import foodbox.Capstone.global.GlobalData;
import foodbox.Capstone.model.Product;
import foodbox.Capstone.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private ProductService productService;

	@GetMapping("/addToCart/{id}")
	public String addTOCart(@PathVariable int id) {
		GlobalData.cart.add(productService.getProductByid(id).get());
		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String cartGet(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "cart";
	}

	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}

	@PostMapping("/payNow")
	public String orderplaced(Model model) {

		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		List<Product> data = GlobalData.cart;
		model.addAttribute("hello", data);
		return "orderPlaced";
	}
}
