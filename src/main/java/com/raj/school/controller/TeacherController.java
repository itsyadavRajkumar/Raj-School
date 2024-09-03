package com.raj.school.controller;

import com.raj.school.payload.TeachersDto;
import com.raj.school.service.TeachersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@AllArgsConstructor
public class TeacherController {
    @Autowired
    private final TeachersService teachersService;

    @PostMapping("/teacher")
    public ResponseEntity<TeachersDto> newTeacher(@RequestBody TeachersDto teachersDto) {
        return new ResponseEntity<>(teachersService.newJoiningOfTeacher(teachersDto), HttpStatus.CREATED);
    }
}
