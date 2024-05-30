package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.UserManagementRecord;
import com.example.usermanagement.Entity.UserRecord;
import com.example.usermanagement.Exception.UserNotFoundException;
import com.example.usermanagement.Repository.IUserManagementRepository;
import com.example.usermanagement.Repository.IUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserRecord findByInfo(String login_id, String password) {
        if (iUserRepository.findByInfo(login_id, password) == null ) {
            throw new UserNotFoundException();
        }
        return iUserRepository.findByInfo(login_id,password);
    }



}