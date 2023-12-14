package c0rnell.flexer.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Human {

    @Id
    private Long id;

    private String name;
}
