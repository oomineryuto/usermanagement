package com.example.usermanagement.Entity;

public record UserManagementRecord(Integer id,Integer product_id,Integer category_id,
                                   String name,Integer price,String image_path,String description,
                                   String created_at,String updated_at) {
}
