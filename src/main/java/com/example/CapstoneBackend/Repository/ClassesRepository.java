package com.example.CapstoneBackend.Repository;
import java.util.ArrayList;
import java.util.Optional;
import com.example.CapstoneBackend.Entity.ClassesEntity;
import org.springframework.data.repository.CrudRepository;



public interface ClassesRepository extends CrudRepository<ClassesEntity, Integer> {
    ArrayList<ClassesEntity> findAllByprofessorid(int professorid);
    Optional<ClassesEntity>findBycourseName(String courseName);
    void deleteById(String classID);
    void delete (ClassesEntity ClassesEntity);
    //The classics are already apart of this such as: findbyid, save, delete etc
    //only put functions here that are specific to our code such as searching on a specific
    //variable
    
}
