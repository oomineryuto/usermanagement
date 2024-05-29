package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.UserManagementRecord;

import java.util.List;

public interface IUserManagementRepository {
    public List<UserManagementRecord> findAll();
}
