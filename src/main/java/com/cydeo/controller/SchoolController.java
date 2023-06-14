package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;
    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
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

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getAllParents(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent","Returned")
                .body(new ResponseWrapper(true,"Parents are successfully retrieved",HttpStatus.ACCEPTED.value(),parentService.findAll()));
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddressById(@PathVariable Long id) throws Exception {

        AddressDTO dto= addressService.findById(id);
            return ResponseEntity.ok(new ResponseWrapper("Address of "+id+"is successfully retrieved",dto));

    }

    @PutMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO) throws Exception {
        addressService.update(addressDTO);
        return  ResponseEntity.ok(new ResponseWrapper("Address is successfully updated",HttpStatus.OK));
    }
}
