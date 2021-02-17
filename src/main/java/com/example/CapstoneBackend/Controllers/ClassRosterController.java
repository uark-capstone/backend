package com.example.CapstoneBackend.Controllers;

import com.example.CapstoneBackend.Commands.ClassRosterCommands;
import com.example.CapstoneBackend.DTO.ClassRosterDTO;
import com.example.CapstoneBackend.Entity.ClassRosterEntity;

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
@RequestMapping(value = "/classRoster")
public class ClassRosterController {

    @Autowired
    ClassRosterCommands classRosterCommands;

    // We can pass the ClassRosterEntity as a param because Springboot maps the values of
    // the json to
    // fields in the ClasRosterEntity class

    // CREATE ClassRoster
    @RequestMapping(value = "/addClassRoster", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody ClassRosterEntity classRosterEntity) {
        
        try {
            classRosterCommands.createNewClassRoster(classRosterEntity);
            return ResponseEntity.status(HttpStatus.OK).body(classRosterEntity.getclassId()+ " was added!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // GETS CLASSROSTER BY CLASSID
    @RequestMapping(value = "/getClassrosterByClassId", params = { "classId" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByClassId(@RequestParam("classId") String classId) {

        try {
            ClassRosterDTO classRosterDTO = classRosterCommands.getClassRosterByClassID(classId);
            return ResponseEntity.status(HttpStatus.OK).body(classRosterDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    // DELETE ROSTER VIA CLASSID
    @RequestMapping(value = "/deleteClassRosterByClassId", params = { "classId" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteClassRoster(@RequestParam("classId") String classId) {
        try{
            classRosterCommands.deleteClassRoster(classId); 
            return ResponseEntity.status(HttpStatus.OK).body("Roster for "+classId+" has been deleted.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //DELETE EVERY ROSTER FROM DB
    @RequestMapping(value = "/deleteAllRosters", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteEveryRoster() {

        try {
            classRosterCommands.deleteEveryRoster();
            return ResponseEntity.status(HttpStatus.OK).body("All rosters are deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
