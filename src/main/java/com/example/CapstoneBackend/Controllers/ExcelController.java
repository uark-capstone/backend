// package com.example.CapstoneBackend.Controllers;

// import java.util.List;
// import org.springframework.http.*;
// import org.springframework.http.HttpStatus;
// import org.springframework.validation.annotation.Validated;

// import com.example.CapstoneBackend.DTO.ExcelDTO;

// import org.springframework.web.bind.annotation.*;

// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;


// @CrossOrigin(maxAge = 3600)
// @RestController
// @RequestMapping(value = "/excel")
// public class ExcelController {
//     @RequestMapping(value = "/readingUsers", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE,
//                 MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
// @ResponseBody
// public ResponseEntity<Object> postBody(@RequestPart List<MultipartFile> file) {
//     try {
//         for(int i=0 ; i<file.size(); i++){
//       //     file.iterator()        }
//         return ResponseEntity.status(HttpStatus.OK).body("yeet");
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//     }
// }

// }
