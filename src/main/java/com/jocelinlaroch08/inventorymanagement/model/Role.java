package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity{

    @JoinColumn(name = "label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
