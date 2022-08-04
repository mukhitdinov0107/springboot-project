package uz.pdp.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootproject.dto.CategoryDto;
import uz.pdp.springbootproject.dto.Result;
import uz.pdp.springbootproject.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }
    @PutMapping("/id")
    public Result editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        Result result = categoryService.editCategory(id, categoryDto);
        return  result;
    }
    @DeleteMapping("/id")
    public Result deleteCategory(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        return result;
    }
}
