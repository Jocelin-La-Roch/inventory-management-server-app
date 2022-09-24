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
@Table(name = "companies")
public class Company extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Embedded
    private Address address;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "company")
    private List<User> users;

}
