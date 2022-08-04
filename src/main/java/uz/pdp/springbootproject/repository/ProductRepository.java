package uz.pdp.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByNameAndCategoryId(String name, Integer id);
}
