package com.example.CapstoneBackend.Controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.example.CapstoneBackend.Commands.ClassRosterCommands;
import com.example.CapstoneBackend.DTO.ClassRosterDTO;
import com.example.CapstoneBackend.Entity.ClassRosterEntity;
import com.example.CapstoneBackend.Repository.ClassRosterRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.http.*;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;


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

    // CSV cannot be in UTF-8 or UTF-8 BOM, will save null values
    // make sure it just saves as a CSV(comma delimited) .csv 
    // CSV class roster
    @PostMapping ("/uploadClassRoster")
    @ResponseBody
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {

        if(file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File is empty.");
        } else {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<ClassRosterDTO> csvToBean = new CsvToBeanBuilder<ClassRosterDTO>(reader)
            .withType(ClassRosterDTO.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build();

            List<ClassRosterDTO> classRosters = csvToBean.parse();
            for(ClassRosterDTO classRoster : classRosters) {
                ClassRosterEntity classRosterEntity = new ClassRosterEntity();
                classRosterEntity.setclassId(classRoster.getclassId());
                classRosterEntity.setuserId(classRoster.getuserId());
                classRosterCommands.createNewCSVClassRoster(classRosterEntity);

            }
            return ResponseEntity.status(HttpStatus.OK).body("Roster added!");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    }

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
