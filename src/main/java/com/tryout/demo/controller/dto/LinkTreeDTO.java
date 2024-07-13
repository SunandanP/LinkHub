package com.tryout.demo.controller.dto;

import com.tryout.demo.db.entity.TreeNodeUrl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
public class LinkTreeDTO {
    private long id;
    private long userAccountId;
    private String password;
    private List<TreeNodeUrl> tree;
}
