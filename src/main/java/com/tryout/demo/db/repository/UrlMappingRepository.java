package com.tryout.demo.db.repository;

import com.tryout.demo.db.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<UrlMapping, Long> specifies that the table entries are of type URL Mappings and the type of the primary key is Long.
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

}
