package com.tryout.demo.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    @Id
    private long id;
    private String userName;
    @JsonIgnore
    private String password;
    @OneToMany
    private List<LinkTree> linkTrees;
}
