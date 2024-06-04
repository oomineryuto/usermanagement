package com.example.usermanagement.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserForm {
    @NotBlank(message = "IDは必須入力です")
    private String loginId;
    @NotBlank(message = "passは必須入力です")
    private String password;


}
