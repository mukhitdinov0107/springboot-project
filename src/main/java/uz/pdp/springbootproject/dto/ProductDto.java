package uz.pdp.springbootproject.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class ProductDto {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer MeasurementId;
}
