package com.tryout.demo.db.repository;

import com.tryout.demo.db.entity.LinkTree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkTreeRepository extends JpaRepository<LinkTree, Long>{
    LinkTree findByUrl(String url);
}
