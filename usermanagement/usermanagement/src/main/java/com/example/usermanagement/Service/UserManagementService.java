package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;
import com.example.usermanagement.Repository.IUserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService implements IUserManagementService {
   @Autowired
   private IUserManagementRepository iUserManagementRepository;
    @Override
    public List<ProductRecord> findAll(){
        return iUserManagementRepository.findAll();
    }
    @Override
    public int insert(ProductInsert productInsert){
        return iUserManagementRepository.insert(productInsert);
    }
    @Override
    public ProductInsert findByName(String name){
        return iUserManagementRepository.findByName(name);
    }
}
