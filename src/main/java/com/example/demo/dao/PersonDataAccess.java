package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.person;
@Repository("postgres")
public class PersonDataAccess implements PersonDao {
    private final JdbcTemplate jdbcTem;
    @Autowired
    public PersonDataAccess(JdbcTemplate jdbcTem) {
        this.jdbcTem = jdbcTem;
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
        final String sql = "SELECT id, name FROM person ";
        try {
            List<person> people = jdbcTem.query(sql, (resultSet, i)-> {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                return new person(id ,name );
        } catch (Exception e) {
            // TODO: handle exception
        }
        });
        
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
