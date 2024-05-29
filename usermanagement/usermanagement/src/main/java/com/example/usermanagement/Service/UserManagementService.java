package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.UserManagementRecord;
import com.example.usermanagement.Repository.IUserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService implements IUserManagementService {
   @Autowired
   private IUserManagementRepository iUserManagementRepository;
    @Override
    public List<UserManagementRecord> findAll(){
        return iUserManagementRepository.findAll();
    }
}
