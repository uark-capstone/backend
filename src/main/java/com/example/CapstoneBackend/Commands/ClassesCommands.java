package com.example.CapstoneBackend.Commands;
import java.util.Optional;
import com.example.CapstoneBackend.DTO.ClassesDTO;
import com.example.CapstoneBackend.Entity.ClassesEntity;
import com.example.CapstoneBackend.HelperClasses.CustomExceptions;
import com.example.CapstoneBackend.Repository.ClassesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserCommands holds all the functions that apply to the UserEntity class
 */ 
@Service
public class ClassesCommands {
    @Autowired // autowire allows us to automatically create a UserRepository instance and use
               // it anywhere
    ClassesRepository classesRepository;

    // CREATING A NEW CLASS
    public void createNewClass(ClassesEntity paramClassesEntity) {
        Optional<ClassesEntity> classesEntity = classesRepository.findBycourseName(paramClassesEntity.getcourseName());
        if (!classesEntity.isPresent()) {
            classesRepository.save(paramClassesEntity);
        } else {
            throw new CustomExceptions.CreationException("Class"); 
        }

    }

    // GETTING CLASS BY PROFESSORID
    public ClassesDTO getClassByProfessorID(int professorid) {
        ClassesDTO classesDTO = new ClassesDTO();
        Optional<ClassesEntity> classesEntity = classesRepository.findByprofessorid(professorid);
        if (!classesEntity.isPresent()) {
            throw new CustomExceptions.NotFoundException("Class");
        }

        // ModelMapper allows us to automatically map our entity to a DTO class, instead
        // of
        // doing userDTO.setName(entity.getName()) on every single variable

        ModelMapper modelMapper = new ModelMapper();
        classesDTO = modelMapper.map(classesEntity.get(), ClassesDTO.class);
        return classesDTO;
    }

    // GETTING CLASS BY COURSENAME
    public ClassesDTO getClassbyCourseName(String courseName) {
        ClassesDTO classesDTO = new ClassesDTO();
        Optional<ClassesEntity> classesEntity = classesRepository.findBycourseName(courseName);
        if (!classesEntity.isPresent()) {
            throw new CustomExceptions.NotFoundException("Class");
        }

        ModelMapper modelMapper = new ModelMapper();
        classesDTO = modelMapper.map(classesEntity.get(), ClassesDTO.class);
        return classesDTO;
    }

    // UPDATE FIELDS ON A USER

    // DELETE CLASS VIA PROFESSORID
    public void deleteClass(int professorid) {
        Optional<ClassesEntity> classesEntity = classesRepository.findByprofessorid(professorid);
        if (classesEntity.isPresent()) {
            classesRepository.delete(classesEntity.get());
        } else {
            throw new CustomExceptions.NoDeleteException("Class");
        }
    }

    // DELETE CLASS VIA COURSENAME
    public void deleteClass(String courseName) {
        Optional<ClassesEntity> classesEntity = classesRepository.findBycourseName(courseName);
        if (classesEntity.isPresent()) {
            classesRepository.delete(classesEntity.get());
        } else {
            throw new CustomExceptions.NoDeleteException("Class");
        }
    }

    // DELETE ALL CLASSES FROM DB
    public void deleteEveryClass() {
        try {
            classesRepository.deleteAll();
        } catch (Exception e) {
            throw new CustomExceptions.NoDeleteException("Classes");
        }

    }

}
