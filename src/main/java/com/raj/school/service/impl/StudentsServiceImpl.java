package com.raj.school.service.impl;

import com.raj.school.entity.Students;
import com.raj.school.exception.ResourceNotFoundException;
import com.raj.school.payload.StudentsDto;
import com.raj.school.repository.StudentsRepository;
import com.raj.school.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private final StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public StudentsDto admission(StudentsDto studentsDto) {

//        Convert DTO to entity

//        Students students = new Students();
//        students.setId(studentsDto.getId());
//        students.setName(studentsDto.getName());
//        students.setFatherName(studentsDto.getFatherName());
//        students.setDOB(studentsDto.getDOB());
//        students.setEmailId(studentsDto.getEmailId());
//        students.setAadharCardNumber(studentsDto.getAadharCardNumber());
//        students.setAddress(studentsDto.getAddress());
//        students.setDepartment(studentsDto.getDepartment());
//        students.setMobileNumber(studentsDto.getMobileNumber());

        Students student = mapToEntity(studentsDto);

        Students newStudent = studentsRepository.save(student);

//        Convert entity to DTO
        return mapToDto(newStudent);

//        StudentsDto studentsResponse = new StudentsDto();
//        studentsResponse.setId(newStudent.getId());
//        studentsResponse.setName(newStudent.getName());
//        studentsResponse.setFatherName(newStudent.getFatherName());
//        studentsResponse.setDOB(newStudent.getDOB());
//        studentsResponse.setAddress(newStudent.getAddress());
//        studentsResponse.setDepartment(newStudent.getDepartment());
//        studentsResponse.setMobileNumber(newStudent.getMobileNumber());
//        studentsResponse.setAadharCardNumber(newStudent.getAadharCardNumber());
//        studentsResponse.setEmailId(newStudent.getEmailId());
//
//        return studentsResponse;

    }

    @Override
    public StudentsDto getStudentById(Long id) {

        Students student = studentsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "id", id));
        return mapToDto(student);
    }

    @Override
    public StudentsDto updateStudent(StudentsDto studentsDto, Long id) {
        Students students = studentsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "id", id));
//        student = mapToEntity(studentsDto);
//        student.setId(studentsDto.getId());
//        studentsRepository.delete(students);

//        students.setId(studentsDto.getId());
        students.setName(studentsDto.getName());
        students.setFatherName(studentsDto.getFatherName());
        students.setDOB(studentsDto.getDOB());
        students.setEmailId(studentsDto.getEmailId());
        students.setAadharCardNumber(studentsDto.getAadharCardNumber());
        students.setAddress(studentsDto.getAddress());
        students.setDepartment(studentsDto.getDepartment());
        students.setMobileNumber(studentsDto.getMobileNumber());

        Students updateStudent = studentsRepository.save(students);
        StudentsDto studentsResponse = mapToDto(updateStudent);
//        studentsResponse.setId(student.getId());
        return studentsResponse;
    }

    @Override
    public void deleteStudentById(Long id) {
        Students student = studentsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "id", id));
        studentsRepository.delete(student);
    }

//    entity to Dto
    StudentsDto mapToDto(Students student) {
        StudentsDto studentDto = new StudentsDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setFatherName(student.getFatherName());
        studentDto.setDOB(student.getDOB());
        studentDto.setAddress(student.getAddress());
        studentDto.setDepartment(student.getDepartment());
        studentDto.setMobileNumber(student.getMobileNumber());
        studentDto.setAadharCardNumber(student.getAadharCardNumber());
        studentDto.setEmailId(student.getEmailId());

        return studentDto;
    }

//    Dto to Entity
    Students mapToEntity(StudentsDto studentsDto) {
        Students student = new Students();
        student.setId(studentsDto.getId());
        student.setName(studentsDto.getName());
        student.setFatherName(studentsDto.getFatherName());
        student.setDOB(studentsDto.getDOB());
        student.setEmailId(studentsDto.getEmailId());
        student.setAadharCardNumber(studentsDto.getAadharCardNumber());
        student.setAddress(studentsDto.getAddress());
        student.setDepartment(studentsDto.getDepartment());
        student.setMobileNumber(studentsDto.getMobileNumber());

        return student;
    }
}
