package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "suppliers")
public class Supplier extends AbstractEntity{

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Embedded
    private Address address;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> orders;

}
