package foodbox.Capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodbox.Capstone.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
