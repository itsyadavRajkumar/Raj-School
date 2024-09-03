package com.raj.school.service;

import com.raj.school.payload.StudentsDto;


public interface StudentsService {
    StudentsDto admission(StudentsDto studentsDto);
    StudentsDto getStudentById(Long id);
    StudentsDto updateStudent(StudentsDto studentsDto, Long id);
    void deleteStudentById(Long id);
}
