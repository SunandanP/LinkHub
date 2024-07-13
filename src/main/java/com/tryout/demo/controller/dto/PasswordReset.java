package com.tryout.demo.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class PasswordReset {
    private String userName;
    private String password;
    private String newPassword;
}
