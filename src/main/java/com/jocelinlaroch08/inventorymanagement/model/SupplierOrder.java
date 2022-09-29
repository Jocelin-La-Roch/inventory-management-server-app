package com.jocelinlaroch08.inventorymanagement.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "supplier_orders")
public class SupplierOrder extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "company_id")
    private Integer companyId;

    @OneToMany(mappedBy = "order")
    private List<SupplierOrderLine> lines;
}
