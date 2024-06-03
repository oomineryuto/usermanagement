package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;
import com.example.usermanagement.Entity.ProductUpdate;

import java.util.List;

public interface IUserManagementRepository {
    public List<ProductRecord> findAll();
    int insert(ProductInsert productInsert);
    List<ProductRecord> findByName(String name);
    public ProductRecord findById(Integer id);
    public int delete(int id);
    public int update(ProductUpdate productUpdate);
}
