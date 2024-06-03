package com.example.usermanagement.form;

import lombok.Data;

@Data
public class UpdateForm {
    private  Integer id;
    private String product_id;
    private String name;
    private Integer price;
    private Integer category_id;
    private String description;
}
