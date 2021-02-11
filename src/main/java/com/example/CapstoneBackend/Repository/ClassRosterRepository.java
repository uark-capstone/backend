package com.example.CapstoneBackend.Repository;
import java.util.Optional;
import com.example.CapstoneBackend.Entity.ClassRosterEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClassRosterRepository extends CrudRepository<ClassRosterEntity, Integer> {

    Optional<ClassRosterEntity>findByClassId(String ClassId);

    //void delete (ClassRosterEntity classRosterEntity); // kind of redundant
}
