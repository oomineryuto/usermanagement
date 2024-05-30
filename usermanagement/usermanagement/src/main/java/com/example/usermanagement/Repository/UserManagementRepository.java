package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.ProductInsert;
import com.example.usermanagement.Entity.ProductRecord;
import com.example.usermanagement.Entity.UserManagementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserManagementRepository implements IUserManagementRepository{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public List<ProductRecord> findAll() {
        return jdbcTemplate.query("SELECT product_id,products.name,price,categories.name AS category_name,description,category_id FROM products INNER JOIN categories ON products.category_id = categories.id  ORDER BY products.id",
                new DataClassRowMapper<>(ProductRecord.class));
    }
    @Override
    public int insert(ProductInsert productInsert) {
        var param = new MapSqlParameterSource();
        param.addValue("product_id", productInsert.product_id());
        param.addValue("name", productInsert.name());
        param.addValue("price",productInsert.price());
        param.addValue("category_id",productInsert.category_id());
        param.addValue("description",productInsert.description());
        return jdbcTemplate.update("INSERT INTO products(product_id,name,price,category_id,description) VALUES(:product_id, :name, :price, :category_id, :description)", param);
    }
    @Override
    public ProductInsert findByName(String name) {
        var param = new MapSqlParameterSource();
        param.addValue("name","%"+name+"%");
        var list = jdbcTemplate.query("SELECT * FROM products WHERE name LIKE :name", param, new DataClassRowMapper<>(ProductInsert.class));
        return list.isEmpty() ? null : list.get(0);
    }
}