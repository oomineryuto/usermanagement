package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.UserRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserRepository {
    public UserRecord findByInfo(String  login_id, String password);
}
