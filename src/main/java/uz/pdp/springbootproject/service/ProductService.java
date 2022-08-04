package uz.pdp.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.springbootproject.dto.ProductDto;
import uz.pdp.springbootproject.dto.Result;
import uz.pdp.springbootproject.entity.Attachment;
import uz.pdp.springbootproject.entity.Category;
import uz.pdp.springbootproject.entity.Measurement;
import uz.pdp.springbootproject.entity.Product;
import uz.pdp.springbootproject.repository.AttachmentRepository;
import uz.pdp.springbootproject.repository.CategoryRepository;
import uz.pdp.springbootproject.repository.MeasurementRepository;
import uz.pdp.springbootproject.repository.ProductRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addProduct(@RequestBody ProductDto productDto){
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return new Result("Bunday Maxsulot Ushbu kategoriyada mavjud", false);
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday category mavjud emas", false);
        }
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent()){
            return new Result("Bunday photo mavjud emas", false);
        }
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday Measurement mavjud emas", false);
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Mahsulot Saqlandi", true);
    }
    public Result editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return new Result("Mahsulot mavjud emas", false);
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setCode("1");

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday category mavjud emas", false);
        }
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent()){
            return new Result("Bunday photo mavjud emas", false);
        }
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday Measurement mavjud emas", false);
        }
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Product edited", true);
    }

    public Result deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return new Result("Product Deleted", true);
    }
}
