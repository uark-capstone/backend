package com.example.CapstoneBackend.Repository;
import java.util.Optional;
import com.example.CapstoneBackend.Entity.ClassesEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClassesRepository extends CrudRepository<ClassesEntity, Integer> {
    Optional<ClassesEntity>findByprofessorid(int professorid);
    Optional<ClassesEntity>findBycourseName(String courseName);
    void delete (ClassesEntity ClassesEntity);
    //The classics are already apart of this such as: findbyid, save, delete etc
    //only put functions here that are specific to our code such as searching on a specific
    //variable
    
}
