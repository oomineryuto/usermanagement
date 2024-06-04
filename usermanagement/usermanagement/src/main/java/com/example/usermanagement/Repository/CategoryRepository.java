package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.CategoryRecord;
import com.example.usermanagement.Entity.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public List<CategoryRecord> categoryFindAll() {
        return jdbcTemplate.query("SELECT id,name FROM categories ORDER BY id",
                new DataClassRowMapper<>(CategoryRecord.class));
    }
}
