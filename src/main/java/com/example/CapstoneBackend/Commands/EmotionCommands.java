package com.example.CapstoneBackend.Commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.CapstoneBackend.DTO.EmotionDTO;
import com.example.CapstoneBackend.Entity.EmotionEntity;
import com.example.CapstoneBackend.Repository.EmotionRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmotionCommands {
    @Autowired
    EmotionRepository emotionRepository;

    // create new entry
    public void createEmotionEntry(EmotionEntity paramEmotionEntity) {
        emotionRepository.save(paramEmotionEntity);
    }

    public List<EmotionDTO> getEmotionsForUser(int lectureID, int userID) {
        List<EmotionDTO> emotionDTO = new ArrayList<EmotionDTO>();
        List<EmotionEntity> emotionEntity = emotionRepository.getAllEmotionsForUser(lectureID, userID);

        // emotionDTO = ObjectMapperUtils.mapAll(emotionEntity, EmotionDTO.class);
        ModelMapper modelMapper = new ModelMapper();
        emotionDTO = emotionEntity.stream().map(entity -> modelMapper.map(entity, EmotionDTO.class))
                .collect(Collectors.toList());
        return emotionDTO;
    }

    public List<EmotionDTO> getEmotionsByLectureID(int lectureID) {
        List<EmotionDTO> emotionDTO = new ArrayList<EmotionDTO>();
        List<EmotionEntity> emotionEntities = emotionRepository.getAllEmotionsbylectureID(lectureID);

        ModelMapper modelMapper = new ModelMapper();
        emotionDTO = emotionEntities.stream().map(emotionEntity -> modelMapper.map(emotionEntity, EmotionDTO.class))
                .collect(Collectors.toList());
        return emotionDTO;
    }

}
