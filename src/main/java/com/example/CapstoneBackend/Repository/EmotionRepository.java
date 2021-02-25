package com.example.CapstoneBackend.Repository;

import java.util.List;
import java.util.Optional;

import com.example.CapstoneBackend.Entity.EmotionEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmotionRepository extends CrudRepository<EmotionEntity, Integer> {
    // idk what we need here
    Optional<EmotionEntity> findBylectureID(int lectureID);
    Optional<EmotionEntity> findByuserID(int userID);
    // idk if this one is needed
    Optional<EmotionEntity> findByemotions(String emotions);
    
    @Query("select * from table where id = (select id from table where class_id = @variable")
    List<EmotionEntity> getAllEmotionsbyclassID(int classID);

}
