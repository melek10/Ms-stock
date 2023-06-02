package tn.indigo.msstock.entities;

import entities.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends BaseEntity {

    private LocalDate DateArretStock;
    private String Description;


}
