package com.tryout.demo.db.repository;

import com.tryout.demo.db.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
    UserAccount findUserAccountByUserNameAndPassword(String userName, String password);
    UserAccount findUserById(long userAccountId);
}
