package foodbox.Capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import foodbox.Capstone.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllBycategory_Id(int id);
	
	@Query("select p from Product p where p.name like %?1% ")
	public  List<Product> findAll(String keyword);
	
	
}
