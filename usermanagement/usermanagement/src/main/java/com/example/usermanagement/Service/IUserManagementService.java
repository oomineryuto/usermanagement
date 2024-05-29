package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.UserManagementRecord;

import java.util.List;

public interface IUserManagementService {
    public List<UserManagementRecord> findAll();
}
