package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.UserRecord;

public interface IUserRepository {
    public UserRecord findByInfo(Integer id, String password);
}
