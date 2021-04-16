package com.example.CapstoneBackend.Commands;

import java.util.Optional;

import com.example.CapstoneBackend.DTO.ClassRosterDTO;
import com.example.CapstoneBackend.Entity.ClassRosterEntity;
import com.example.CapstoneBackend.HelperClasses.CustomExceptions;

import com.example.CapstoneBackend.Repository.ClassRosterRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRosterCommands {
    @Autowired // autowire allows us to automatically create a UserRepository instance and use
               // it anywhere
    ClassRosterRepository classRosterRepository;

    // CREATING A NEW CLASSROSTER
    public void createNewClassRoster(ClassRosterEntity paramClassRosterEntity) {
        Optional<ClassRosterEntity> classRosterEntity = classRosterRepository.findByClassId(paramClassRosterEntity.getclassId());
        if (!classRosterEntity.isPresent()) {
            classRosterRepository.save(paramClassRosterEntity);
        } else {
            throw new CustomExceptions.CreationException("ClassRoster"); 
        }

    }


    // Create class roster from csv
    public void createNewCSVClassRoster(ClassRosterEntity paramClassRosterEntity) {
        Optional<ClassRosterEntity> classRosterEntity = classRosterRepository.findByClassIdAndUserId(paramClassRosterEntity.getclassId(), 
                                                                                paramClassRosterEntity.getuserId());
        if(!classRosterEntity.isPresent()) {
            classRosterRepository.save(paramClassRosterEntity);
        } else {
            throw new CustomExceptions.CreationException("ClassRoster");
        }
    }
    // GETTING CLASSROSTER BY CLASSID
    public ClassRosterDTO getClassRosterByClassID(String classId) {
        ClassRosterDTO classRosterDTO = new ClassRosterDTO();
        Optional<ClassRosterEntity> classRosterEntity = classRosterRepository.findByClassId(classId);
        if (!classRosterEntity.isPresent()) {
            throw new CustomExceptions.NotFoundException("ClassRoster");
        }

        // ModelMapper allows us to automatically map our entity to a DTO class, instead
        // of
        // doing userDTO.setName(entity.getName()) on every single variable

        ModelMapper modelMapper = new ModelMapper();
        classRosterDTO = modelMapper.map(classRosterEntity.get(), ClassRosterDTO.class);
        return classRosterDTO;
    }

    

    // UPDATE FIELDS ON A USER

    // DELETE CLASSROSTER VIA CLASSID
    public void deleteClassRoster(String classId) {
        Optional<ClassRosterEntity> classRosterEntity = classRosterRepository.findByClassId(classId);
        if (classRosterEntity.isPresent()) {
            classRosterRepository.delete(classRosterEntity.get());
        } else {
            throw new CustomExceptions.NoDeleteException("ClassRosters");
        }
    }

    // DELETE ALL ROSTERS FROM DB
    public void deleteEveryRoster() {
        try {
            classRosterRepository.deleteAll();
        } catch (Exception e) {
            throw new CustomExceptions.NoDeleteException("ClassRosters");
        }

    }
}
