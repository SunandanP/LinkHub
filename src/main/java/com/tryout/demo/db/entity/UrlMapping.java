package com.tryout.demo.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

// Marking this class as the class which will be stored in the table by the name URLMAPPING
@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UrlMapping {
    @Id
    @GeneratedValue
    private long id;
    private String url;
    private String generatedURL;


}
