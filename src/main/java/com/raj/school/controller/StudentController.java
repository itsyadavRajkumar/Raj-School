package com.raj.school.controller;

import com.raj.school.payload.StudentsDto;
import com.raj.school.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
public class StudentController {
    @Autowired
    private final StudentsService studentsService;

    @PostMapping("/students")
    public ResponseEntity<StudentsDto> admissionStudent(@RequestBody StudentsDto studentsDto) {
        return new ResponseEntity<>(studentsService.admission(studentsDto), HttpStatus.CREATED);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentsDto> getStudentById(@PathVariable Long id) {
        StudentsDto studentDto = studentsService.getStudentById(id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);  // Changed to HttpStatus.OK
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
//        StudentsDto studentsDto =
        studentsService.deleteStudentById(id);
        return new ResponseEntity<>("Student Delete Successfully!", HttpStatus.OK);
    }

}
