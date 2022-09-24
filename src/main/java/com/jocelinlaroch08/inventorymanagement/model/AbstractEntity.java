package com.jocelinlaroch08.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creation_date", nullable = false)
    @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate;
}
