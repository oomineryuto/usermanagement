package com.example.usermanagement.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {
    @NotBlank(message = "商品IDは必須です")
    private String product_id;
    @NotBlank(message = "名前は必須です")
    private String name;
    @NotNull(message = "値段は必須です")
    private Integer price;
    @NotNull(message = "カテゴリーは必須です")
    private Integer category_id;
    private String description;
}
