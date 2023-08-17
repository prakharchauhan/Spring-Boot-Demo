package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import javax.swing.text.html.Option;

import org.springframework.stereotype.Repository;

import com.example.demo.model.person;
@Repository("fakeDao")
public class DataAccessService implements PersonDao {
    private static List<person>DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, person per){
        DB.add(new person(id, per.getName()));
        
        return 1;
    }
    @Override
    public List<person> selectAllpeople(){
        return DB;
    }
    @Override
     public int deletePerson(UUID id){
        Optional<person> maybe = selectPersonById(id);
        if (maybe.isEmpty()){
            return 0;
        }
        DB.remove(maybe.get());
        return 1;
     }
    @Override

     public int updatePerson(UUID id, person update){
        return selectPersonById(id)
                .map(per ->{
                int indexOfP = DB.indexOf(update);
                if(indexOfP>=0){
                DB.set(indexOfP, new person(id, update.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);

     }

    @Override

    public Optional<person> selectPersonById(UUID id){
        return DB.stream().filter(per-> per.getID().equals(id)).findFirst();
        
    }


}
