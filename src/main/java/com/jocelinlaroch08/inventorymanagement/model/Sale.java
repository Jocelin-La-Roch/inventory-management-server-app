package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sales")
public class Sale extends AbstractEntity{
    @Column(name = "code")
    private String code;

}
