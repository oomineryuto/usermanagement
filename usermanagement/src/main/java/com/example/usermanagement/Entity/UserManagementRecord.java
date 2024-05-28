package com.example.usermanagement.Entity;

public record UserManagementRecord(Integer id,Integer productId,Integer categoryId,
                                   String name,Integer price,String imagePath,String description,
                                   String createdAt,String updateAt) {
}
