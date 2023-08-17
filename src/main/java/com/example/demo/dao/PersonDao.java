package com.example.demo.dao;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.person;
public interface PersonDao {
    int insertPerson (UUID id, person per);


    default int insertPerson(person per){
        UUID id = UUID.randomUUID();
        return insertPerson(id, per);
    }

    List<person> selectAllpeople();
    Optional<person> selectPersonById(UUID id);
    int deletePerson(UUID id);
    int updatePerson(UUID id, person per);
}
