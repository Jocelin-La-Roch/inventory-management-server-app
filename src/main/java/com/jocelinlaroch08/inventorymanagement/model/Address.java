package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address {

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;
}
