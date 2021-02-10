package com.example.CapstoneBackend.Commands;

import java.util.Optional;

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
        // not sure what to check for here
        emotionRepository.save(paramEmotionEntity);
    }

    // dont know how to really do any of this

    // get emotions by user id
    public EmotionDTO getEmotionByUserID(int id) {
        EmotionDTO emotionDTO = new EmotionDTO();
        Optional<EmotionEntity> emotionEntity = emotionRepository.findByuserID(id);

        ModelMapper modelMapper = new ModelMapper();
        emotionDTO = modelMapper.map(emotionEntity.get(), EmotionDTO.class);
        return emotionDTO;
    }
    
    
}
