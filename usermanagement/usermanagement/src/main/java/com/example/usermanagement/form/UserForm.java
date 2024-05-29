package com.example.usermanagement.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserForm {
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
