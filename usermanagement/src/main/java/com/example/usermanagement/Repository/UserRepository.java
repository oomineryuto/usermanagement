package com.example.usermanagement.Repository;

import com.example.usermanagement.Entity.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public UserRecord findByInfo(Integer id,String password) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        param.addValue("password",password);
        var list = jdbcTemplate.query("SELECT * FROM users WHERE id = :id AND password = :password", param, new DataClassRowMapper<>(UserRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }
}
