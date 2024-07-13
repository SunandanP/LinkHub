package com.tryout.demo.controller;

import com.tryout.demo.service.UrlHandlerService;
import com.tryout.demo.db.entity.LinkTree;
import com.tryout.demo.db.entity.UserAccount;
import com.tryout.demo.db.repository.LinkTreeRepository;
import com.tryout.demo.db.repository.UserAccountRepository;
import com.tryout.demo.controller.dto.LinkTreeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTreeController {
    @Autowired
    private LinkTreeRepository linkTreeRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;


    @Autowired
    UrlHandlerService urlHandlerService;

    @PostMapping("/create-link-tree")
    public LinkTree createLinkTree(@RequestBody LinkTreeDTO linkTree) {
         UserAccount account = userAccountRepository.findUserAccountByUserNameAndPassword(
                userAccountRepository.findUserById(linkTree.getUserAccountId()).getUserName(),
                linkTree.getPassword());
         if (account != null) {
             LinkTree newLinkTree = new LinkTree();
             newLinkTree.setUrl(urlHandlerService.generateUrl());
             newLinkTree.setTree(linkTree.getTree());
             newLinkTree.setUserAccount(account);
             return linkTreeRepository.save(newLinkTree);
         }

         return new LinkTree();
    }

    @PutMapping("/update-link-tree")
    public LinkTree updateLinkTree(@RequestBody LinkTreeDTO linkTree) {
        UserAccount account = userAccountRepository.findUserAccountByUserNameAndPassword(
                userAccountRepository.findUserById(linkTree.getUserAccountId()).getUserName(),
                linkTree.getPassword());
        if (account != null) {
            LinkTree existingLinkTree = linkTreeRepository.findById(linkTree.getId()).orElse(null);
            if (existingLinkTree != null) {
                existingLinkTree.setTree(linkTree.getTree());
                existingLinkTree.setUserAccount(account);
                return linkTreeRepository.save(existingLinkTree);
            }
        }

        return new LinkTree();
    }

    @DeleteMapping("/delete-link-tree")
    public void deleteLinkTree(@RequestBody LinkTreeDTO linkTree) {
        UserAccount account = userAccountRepository.findUserAccountByUserNameAndPassword(
                userAccountRepository.findUserById(linkTree.getUserAccountId()).getUserName(),
                linkTree.getPassword());
        if (account != null) {
            LinkTree existingLinkTree = linkTreeRepository.findById(linkTree.getId()).orElse(null);
            if (existingLinkTree != null) {
                linkTreeRepository.delete(existingLinkTree);
            }
        }
    }

    @GetMapping("link-tree/{url}")
    public LinkTree getLinkTree(@PathVariable String url) {
        return linkTreeRepository.findByUrl(url);
    }
}
