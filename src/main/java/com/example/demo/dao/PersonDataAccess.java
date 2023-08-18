package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
//import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.model.person;
@Repository("postgres")
public class PersonDataAccess implements PersonDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int deletePerson(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    

    @Override
    public int insertPerson(UUID id, person per) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<person> selectAllpeople() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, this::mapRowToPerson);
    }

    private person mapRowToPerson(ResultSet resultSet, int rowNum) throws SQLException {
        UUID id = UUID.fromString(resultSet.getString("id"));
        String name = resultSet.getString("name");
        return new person(id, name);
    }
        
    
    

    @Override
    public Optional<person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public int updatePerson(UUID id, person per) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
