package com.example.CapstoneBackend.Repository;

import java.util.ArrayList;
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

    @Query(value = "select * from emotions e where e.lecture_id = :lectureID", nativeQuery = true)
    ArrayList<EmotionEntity> getAllEmotionsbylectureID(int lectureID);

    @Query(value = "select * from emotions e where e.lecture_id = :lectureID and e.user_id = :userID", nativeQuery = true)
    ArrayList<EmotionEntity> getAllEmotionsForUser(int lectureID, int userID);

}
// @Query(value = "select e from emotions where id = (select id from emotions e
// where e.lecture_id = lectureID)", nativeQuery = true)
//