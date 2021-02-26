package com.example.CapstoneBackend.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.DTO.UserEmotionsDTO;
import com.example.CapstoneBackend.Entity.EmotionEntity;
import com.example.CapstoneBackend.Entity.UserEntity;
import com.example.CapstoneBackend.Repository.EmotionRepository;
import com.example.CapstoneBackend.Repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEmotionsCommands {
    @Autowired
    EmotionRepository emotionRepository;

    @Autowired
    UserRepository userRepository;

    public List<UserEmotionsDTO> getEmotionsForUserID(int lectureID, int userID) {
        List<UserEmotionsDTO> userEmotionsDTO = new ArrayList<UserEmotionsDTO>();

        List<EmotionEntity> emotionEntities = emotionRepository.getAllEmotionsForUser(lectureID, userID);

        Optional<UserEntity> userEntity = userRepository.findById(userID);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(userEntity.get(), UserDTO.class);
        
        for(EmotionEntity emotionEntity : emotionEntities) {
            userEmotionsDTO.add(new UserEmotionsDTO(userID, emotionEntity.getEmotions(), 
            emotionEntity.getPercent(), emotionEntity.getTimestamp(), userDTO.getName()));
        }
        return userEmotionsDTO;
    }

    public List<UserEmotionsDTO> getEmotionsForLecture(int lectureID) {
        List<EmotionEntity> emotionEntities = emotionRepository.getAllEmotionsbylectureID(lectureID);
        
        List<UserEmotionsDTO> userEmotionsDTOList = new ArrayList<UserEmotionsDTO>();


        for(EmotionEntity emotionEntity : emotionEntities) {
            Optional<UserEntity> userEntity = userRepository.findById(emotionEntity.getUser_id());
            ModelMapper modelMapper = new ModelMapper();
            UserDTO userDTO = modelMapper.map(userEntity.get(), UserDTO.class);
            userEmotionsDTOList.add(new UserEmotionsDTO(userDTO.getId(), 
            emotionEntity.getEmotions(), emotionEntity.getPercent(), emotionEntity.getTimestamp(), 
            userDTO.getName()));
        }
        return userEmotionsDTOList;

    }

}
