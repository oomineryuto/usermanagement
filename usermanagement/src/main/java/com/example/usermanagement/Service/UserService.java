package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.UserRecord;
import com.example.usermanagement.Repository.IUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserRecord findByInfo(Integer id, String password) {
        if (iUserRepository.findByInfo(id) == null) {
            throw UserNotFoundException();
        }
    }
}