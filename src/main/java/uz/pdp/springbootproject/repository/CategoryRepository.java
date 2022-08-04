package uz.pdp.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootproject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
