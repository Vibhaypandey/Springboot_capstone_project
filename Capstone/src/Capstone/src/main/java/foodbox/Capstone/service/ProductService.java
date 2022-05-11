package foodbox.Capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import foodbox.Capstone.model.Category;
import foodbox.Capstone.model.Product;
import foodbox.Capstone.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public List<Product> getAllproducts() {
		// TODO Auto-generated method stub
		
      return productRepository.findAll() ;
	}
	
	public void addCategory(Product products) {
		// TODO Auto-generated method stub
		this.productRepository.save(products)	;
		
		
		
	}

	
	public void removeProductById(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	
	public Optional<Product> getProductByid(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	
	public List<Product> getAllproductbycategoryId(int id) {
		// TODO Auto-generated method stub
		return productRepository.findAllBycategory_Id(id);
	}
	
	

	public List<Product> findAllthrough(String keyword) {
		// TODO Auto-generated method stub
		if(keyword!=null) {
			return productRepository.findAll(keyword);
		}
		return productRepository.findAll();
	}
	
	
}
