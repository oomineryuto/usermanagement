package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.UserRecord;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public UserRecord findByInfo(String login_id, String password);
}

