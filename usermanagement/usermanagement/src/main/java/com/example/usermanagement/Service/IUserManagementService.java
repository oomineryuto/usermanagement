package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;

import java.util.List;

public interface IUserManagementService {
    public List<ProductRecord> findAll();
    int insert(ProductInsert productInsert);
    List<ProductRecord> findByName(String name);
    public ProductRecord findById(int id);
}
