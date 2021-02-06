package com.example.CapstoneBackend.Repository;
import java.util.Optional;
import com.example.CapstoneBackend.Entity.ClassRosterEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClassRosterRepository extends CrudRepository<ClassRosterEntity, String> {

    Optional<ClassRosterEntity>findByclassId(String classId);

    void delete (ClassRosterEntity classRosterEntity);
}
