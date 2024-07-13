package com.tryout.demo.service;

import com.tryout.demo.db.entity.LinkTree;
import com.tryout.demo.db.entity.UrlMapping;
import com.tryout.demo.db.entity.UserAccount;
import com.tryout.demo.db.repository.LinkTreeRepository;
import com.tryout.demo.db.repository.UrlMappingRepository;
import com.tryout.demo.db.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private LinkTreeRepository linkTreeRepository;

    @Autowired
    private UrlMappingRepository urlMappingRepository;

    @Override
    public void run(String... args) throws Exception {
        // Dummy UserAccounts
        List<UserAccount> userAccounts = Arrays.asList(
            new UserAccount(1L, "user1", "password1", new ArrayList<>()),
            new UserAccount(2L, "user2", "password2", new ArrayList<>())
        );
        userAccountRepository.saveAll(userAccounts);

//         Assuming UrlMapping repository and constructor exist
         List<UrlMapping> urlMappings = Arrays.asList(
             new UrlMapping(1L, "http://example.com", "abc123"),
             new UrlMapping(2L, "http://example.org", "def456")
         );
         urlMappingRepository.saveAll(urlMappings);

        // Dummy LinkTrees
        List<LinkTree> linkTrees = Arrays.asList(
            new LinkTree(1L, "http://example.com/tree1", new ArrayList<>(), userAccounts.get(0)),
            new LinkTree(2L, "http://example.org/tree2", new ArrayList<>(), userAccounts.get(1))
        );
        linkTreeRepository.saveAll(linkTrees);
    }
}