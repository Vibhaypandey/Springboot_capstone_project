package foodbox.Capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodbox.Capstone.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
   
}
