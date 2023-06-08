package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    public SchoolController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }
    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(teacherService.findAll());
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getAllStudent(){
        return  ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved",studentService.findAll()));
    }
}
