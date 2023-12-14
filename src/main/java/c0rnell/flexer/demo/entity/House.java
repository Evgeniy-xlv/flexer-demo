package c0rnell.flexer.demo.entity;

import c0rnell.flexer.model.GenerateModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@GenerateModel
public class House {

    @Id
    private Long id;

    private String address;
}
