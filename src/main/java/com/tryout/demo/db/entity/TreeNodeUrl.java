package com.tryout.demo.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class TreeNodeUrl {
    @Id
    private long id;
    private String url;
    private String name;
    private String description;

    @ManyToOne
    private LinkTree linkTree;
}
