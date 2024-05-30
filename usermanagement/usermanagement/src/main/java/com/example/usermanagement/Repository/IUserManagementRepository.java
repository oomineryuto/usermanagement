package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;

import java.util.List;

public interface IUserManagementRepository {
    public List<ProductRecord> findAll();
    int insert(ProductInsert productInsert);
    ProductInsert findByName(String name);
}
