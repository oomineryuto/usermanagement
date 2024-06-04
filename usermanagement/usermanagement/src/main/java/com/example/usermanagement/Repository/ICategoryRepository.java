package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.CategoryRecord;

import java.util.List;

public interface ICategoryRepository {
    public List<CategoryRecord> categoryFindAll();
}
