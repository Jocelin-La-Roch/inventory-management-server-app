package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

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

    @Column(name = "date")
    private Instant date;

    @Column(name = "comment")
    private String comment;

    @Column(name = "company_id")
    private Integer companyId;

    @OneToMany(mappedBy = "sale")
    private List<SaleLine> lines;

}
