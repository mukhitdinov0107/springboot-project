package uz.pdp.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.springbootproject.dto.CategoryDto;
import uz.pdp.springbootproject.dto.Result;
import uz.pdp.springbootproject.entity.Category;
import uz.pdp.springbootproject.repository.CategoryRepository;

import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Result addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent()){
                return new Result("bunday ota category mavjud emas", false);
            }
            category.setParentCategory(optionalCategory.get());
            categoryRepository.save(category);
            return new Result("Saved successfully", true);
        }
      return new Result("Saqlandi", true);
    }

    public Result editCategory(@PathVariable Integer id, CategoryDto categoryDto) {
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent()){
                return new Result("bunday ota category mavjud emas", false);
            }
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            category.setParentCategory(optionalCategory.get());
            categoryRepository.save(category);
            return new Result("Edited successfully", true);
        }
        return new Result("Saved", true);
    }
    public Result deleteCategory(@PathVariable Integer id){
        categoryRepository.deleteById(id);
        return new Result("Deleted", true);
    }
}
