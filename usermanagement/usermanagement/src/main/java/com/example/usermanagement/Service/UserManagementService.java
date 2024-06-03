package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;
import com.example.usermanagement.Entity.ProductUpdate;
import com.example.usermanagement.Exception.UserNotFoundException;
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
    public List<ProductRecord> findByName(String name){
        return iUserManagementRepository.findByName(name);
    }
    @Override
    public ProductRecord findById(int id){
        if(iUserManagementRepository.findById(id) == null){
            throw new UserNotFoundException();
        }else{
            return iUserManagementRepository.findById(id);
        }
    }
    @Override
    public int delete(int id){
        return iUserManagementRepository.delete(id);
    }
    @Override
    public int update(ProductUpdate productUpdate){
        return iUserManagementRepository.update(productUpdate);
    }


}
