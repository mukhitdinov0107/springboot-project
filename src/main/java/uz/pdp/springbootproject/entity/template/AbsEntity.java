package uz.pdp.springbootproject.entity.template;

import lombok.Data;
import uz.pdp.springbootproject.entity.Category;

import javax.persistence.*;

@Data
@MappedSuperclass

public class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Category parentCategory;

    private String name;

    private boolean active = true;
}
