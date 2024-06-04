package com.example.usermanagement.Service;

import com.example.usermanagement.Entity.CategoryRecord;
import com.example.usermanagement.Entity.ProductRecord;
import com.example.usermanagement.Repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    public List<CategoryRecord> categoryFindAll(){
        return iCategoryRepository.categoryFindAll();
    }
}
