package com.cydeo.controller;

import com.cydeo.dto.TeacherDTO;
import com.cydeo.entity.Teacher;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class SchoolController {
    private final TeacherService teacherService;

    public SchoolController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(teacherService.findAll());
    }
}
