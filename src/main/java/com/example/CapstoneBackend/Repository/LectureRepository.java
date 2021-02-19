package com.example.CapstoneBackend.Repository;

import com.example.CapstoneBackend.Entity.LectureEntity;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<LectureEntity, Integer> {
    // these could all be unnecessary
    Optional<LectureEntity>findByclassID(int classID);
    Optional<LectureEntity>findBylectureName(String lectureName);
    
}
