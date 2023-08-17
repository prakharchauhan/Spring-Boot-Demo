package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.person;
@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao){
        this.personDao = personDao;
    }
    public int addPerson(person per){
        return personDao.insertPerson(per);
    }
    
    public List<person> getAllPeople(){
        return personDao.selectAllpeople();
    }

    public Optional<person> getPerson(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePerson(id);
    }
    public int updatePersonID(UUID id, person per){
        return personDao.updatePerson(id, per);
    }
}
