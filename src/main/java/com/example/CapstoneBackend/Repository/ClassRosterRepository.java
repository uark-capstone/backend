package com.example.CapstoneBackend.Repository;
import java.util.Optional;
import com.example.CapstoneBackend.Entity.ClassRosterEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClassRosterRepository extends CrudRepository<ClassRosterEntity, String> {

    Optional<ClassRosterEntity>findByclass_id(String class_id);

    void delete (ClassRosterEntity classRosterEntity);
}
