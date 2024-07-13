package com.tryout.demo.controller;

import com.tryout.demo.db.entity.UserAccount;
import com.tryout.demo.db.repository.UserAccountRepository;
import com.tryout.demo.controller.dto.PasswordReset;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @PostMapping("/create-account")
    public UserAccount createAccount(@RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount userAccount) {
        return userAccountRepository.findUserAccountByUserNameAndPassword(userAccount.getUserName(), userAccount.getPassword());
    }

    @PostMapping("/update-account")
    public UserAccount updateAccount(@RequestBody PasswordReset request) {
        UserAccount userAccount = userAccountRepository.findUserAccountByUserNameAndPassword(request.getUserName(), request.getPassword());
        if (userAccount == null) {
            return null;
        }
        else userAccount.setPassword(request.getNewPassword());

        return userAccountRepository.save(userAccount);
    }

    @PostMapping("/delete-account")
    public void deleteAccount(@RequestBody UserAccount userAccount) {
        userAccountRepository.delete(userAccount);
    }

}
