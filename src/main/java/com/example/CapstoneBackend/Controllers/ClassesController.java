package com.example.CapstoneBackend.Controllers;

import com.example.CapstoneBackend.Commands.ClassesCommands;
import com.example.CapstoneBackend.DTO.ClassesDTO;
import com.example.CapstoneBackend.Entity.ClassesEntity;
import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that hosts all endpoints related to: USERS
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/class")
public class ClassesController {

    @Autowired
    ClassesCommands classesCommands;

    // We can pass the UserEntity as a param because Springboot maps the values of
    // the json to
    // fields in the UserEntity class

    // CREATE CLASS
    @RequestMapping(value = "/addClass", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody ClassesEntity classesEntity) {
        
        try {
            classesCommands.createNewClass(classesEntity);
            return ResponseEntity.status(HttpStatus.OK).body(classesEntity.getcourseName()+ " was added!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // GETS CLASS BY PROFESSORID
    @RequestMapping(value = "/getClassByProfessorID", params = { "professorid" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByProfessorID(@RequestParam("professorid") int professorid) {

        try {
            ClassesDTO classesDTO = classesCommands.getClassByProfessorID(professorid);
            return ResponseEntity.status(HttpStatus.OK).body(classesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GETS CLASS BY COURSENAME
    @RequestMapping(value = "/getclassByCourseName", params = { "courseName" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByCourseName(@RequestParam("courseName") String courseName) {

        try {
            ClassesDTO classesDTO = classesCommands.getClassbyCourseName(courseName);
            return ResponseEntity.status(HttpStatus.OK).body(classesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE CLASS VIA PROFESSORID
    @RequestMapping(value = "/deleteClassByProfessorID", params = { "professorid" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteClass(@RequestParam("professorid") int professorid) {
        try{
            classesCommands.deleteClass(professorid); 
            return ResponseEntity.status(HttpStatus.OK).body("Class tied to "+professorid+" has been deleted.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE CLASS VIA COURSENAME
    @RequestMapping(value = "/deleteClassByCourseName", params = { "courseName" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteClass(@RequestParam("courseName") String courseName) {
        try{
            classesCommands.deleteClass(courseName); 
            return ResponseEntity.status(HttpStatus.OK).body("Class "+courseName+" been deleted.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //DELETE EVERY CLASS FROM DB
    @RequestMapping(value = "/deleteAllClasses", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteAllClasses() {

        try {
            classesCommands.deleteEveryClass();
            return ResponseEntity.status(HttpStatus.OK).body("All classes are deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
