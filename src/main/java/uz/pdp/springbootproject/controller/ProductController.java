package uz.pdp.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootproject.dto.ProductDto;
import uz.pdp.springbootproject.dto.Result;
import uz.pdp.springbootproject.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto){
        Result result = productService.addProduct(productDto);
        return result;
    }
    @PutMapping("/id")
    public Result editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto){
        Result result = productService.editProduct(id, productDto);
        return result;
    }
    @DeleteMapping("/id")
    public Result deleteProduct(@PathVariable Integer id){
        Result result = productService.deleteProduct(id);
        return result;
    }

}
