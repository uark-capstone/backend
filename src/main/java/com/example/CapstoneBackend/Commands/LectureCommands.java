package com.example.CapstoneBackend.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.CapstoneBackend.DTO.LectureDTO;
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
        Optional<LectureEntity> lectureEntity = lectureRepository
                .findBylectureNameAndClassID(paramLectureEntity.getLectureName(), paramLectureEntity.getClass_id());

        if (!lectureEntity.isPresent()) {
            lectureRepository.save(paramLectureEntity);
        } else {
            throw new CustomExceptions.CreationException("Lecture");
        }

    }

    // Delete Lecture (includes class id in case two classes have the same lecture
    // name)
    public void deleteLecture(String lectureName, int classID) {
        Optional<LectureEntity> lectureEntity = lectureRepository.findBylectureNameAndClassID(lectureName, classID);
        if (lectureEntity.isPresent()) {
            lectureRepository.delete(lectureEntity.get());
        } else {
            throw new CustomExceptions.NoDeleteException("Lectures");
        }
    }

    public List<LectureDTO> getAllLectures() {
        List<LectureDTO> listLectureDTO= new ArrayList<LectureDTO>();  
        List<LectureEntity> lectureEntities = lectureRepository.findAll();
        if (lectureEntities != null) {
            ModelMapper modelMapper = new ModelMapper();
        listLectureDTO = lectureEntities.stream().map(emotionEntity -> modelMapper.map(lectureEntities, LectureDTO.class))
                .collect(Collectors.toList());
        return listLectureDTO; 
        } else {
            throw new CustomExceptions.NoDeleteException("Lectures");
        }
    }


}
