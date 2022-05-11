package foodbox.Capstone.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import foodbox.Capstone.dto.ProductDTO;
import foodbox.Capstone.model.Category;
import foodbox.Capstone.model.Product;
import foodbox.Capstone.service.CategoryService;
import foodbox.Capstone.service.ProductService;


@Controller
public class AdminController {
  
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";

	@GetMapping("/admin")
	public String getAdminHome(){
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String view(Model model) {
		model.addAttribute("categories", categoryService.getAllcategories());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String viewHomePage(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
		}
	@PostMapping("/admin/categories/add")
	public String viewHomePagepost(@ModelAttribute("category") Category category ) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
		}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String showformdelete(@PathVariable(value = "id") int id) {
		// delete employee from the service
		this.categoryService.deleteategorybyid(id);
		  
		  return "redirect:/admin/categories";
	} 
	@GetMapping("/admin/categories/update/{id}")
	public String showcategoryupdate(@PathVariable(value = "id") int id, Model model) {
		// get employee from the service
		 Optional<Category> category = categoryService.getcategorybyid(id);
		 if(category.isPresent()) {
			 model.addAttribute("category", category.get());
			 return "categoriesAdd";
		 }
		 else {
			 return "404";
		 }
	} 
	//product section
	
	@GetMapping("/admin/products")
	public String getAdminHomeforproduts(Model model){
		model.addAttribute("products", productService.getAllproducts());
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String getAdminHomeforprodutsAdd(Model model){
		model.addAttribute("productDTO",new ProductDTO() );
		model.addAttribute("categories", categoryService.getAllcategories());
		return "productsAdd";
	}
	
    
	@PostMapping("/admin/products/add")
	public String saveproductlist(@ModelAttribute("productDTO") ProductDTO productDTO, @RequestParam("productImage")MultipartFile file , @RequestParam("imgName") String imgName) throws IOException {
		
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getcategorybyid(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			
			Path filenameandpath = Paths.get(uploadDir,imageUUID);
			Files.write(filenameandpath, file.getBytes());
		}
		else {
			imageUUID=imgName;
		}
		 product.setImageName(imageUUID);
		 productService.addCategory(product);
				return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String showformdeleteproduct(@PathVariable(value = "id") long id) {
		// delete employee from the service
		this.productService.removeProductById(id);
		  
		  return "redirect:/admin/products";
	}	

	@GetMapping("/admin/product/update/{id}")
	public String showproductupdate(@PathVariable(value = "id") long id,Model model) {
		// get employee from the service
		   Product product = productService.getProductByid(id).get();
		   ProductDTO productDTO = new ProductDTO();
		   productDTO.setId(product.getId());
		   productDTO.setName(product.getName());
		   productDTO.setCategoryId(product.getCategory().getId());
		   productDTO.setPrice(product.getPrice());
		   productDTO.setWeight(product.getWeight());
		   productDTO.setDescription(product.getDescription());
		   productDTO.setImageName(product.getDescription());
		   model.addAttribute("categories",categoryService.getAllcategories() );
		   model.addAttribute("productDTO", productDTO);
		   return "productsAdd";
		}


}
