package com.tryout.demo.db.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkTree {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String url;
    @OneToMany
    private List<TreeNodeUrl> tree;

    @ManyToOne
    private UserAccount userAccount;

}
