package io.github.kjm015.kylenewer.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class KyleTable {

    @Id
    private Long id;

    private String message;

}
