package uz.pdp.springbootproject.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.springbootproject.entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Currency extends AbsEntity {

}
