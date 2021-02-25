package com.example.CapstoneBackend.Commands;

import java.util.Optional;

import com.example.CapstoneBackend.Entity.LectureEntity;
import com.example.CapstoneBackend.HelperClasses.CustomExceptions;
import com.example.CapstoneBackend.Repository.LectureRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureCommands {

    @Autowired
    LectureRepository lectureRepository;

    // create new lecture entry
    // this is assuming each lecture has to be a different name
    // (david andrews stores multiple lectures under one name)
    // NEEDS TO ALSO CHECK CLASS ID AND LECTURE NAME
    public void createNewLecture(LectureEntity paramLectureEntity) {
        Optional<LectureEntity> lectureEntity = lectureRepository.findBylectureName(paramLectureEntity
                                                                                    .getLectureName());
        Optional<LectureEntity> lectureClassEntity = lectureRepository.findByclassID(paramLectureEntity.getClass_id());

        if(lectureEntity.isPresent()) {
            if(!lectureClassEntity.isPresent()) {
                lectureRepository.save(paramLectureEntity);
            }
        } 
        else if(!lectureEntity.isPresent()) {
            lectureRepository.save(paramLectureEntity);
        } else {
            throw new CustomExceptions.CreationException("Lecture");
        }

    }
}
