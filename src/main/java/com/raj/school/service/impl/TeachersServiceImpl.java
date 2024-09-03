package com.raj.school.service.impl;

import com.raj.school.entity.Teachers;
import com.raj.school.payload.TeachersDto;
import com.raj.school.repository.TeachersRepository;
import com.raj.school.service.TeachersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private final TeachersRepository teachersRepository;


    @Override
    public TeachersDto newJoiningOfTeacher(TeachersDto teachersDto) {
        Teachers teachers = new Teachers();

//        convert dto to entity
        teachers.setId(teachersDto.getId());
        teachers.setName(teachersDto.getName());
        teachers.setFatherName(teachersDto.getFatherName());
        teachers.setEmailId(teachersDto.getEmailId());
        teachers.setDOB(teachersDto.getDOB());
        teachers.setMobileNumber(teachersDto.getMobileNumber());
        teachers.setAddress(teachersDto.getAddress());
        teachers.setAadharCardNumber(teachersDto.getAadharCardNumber());

        Teachers newTeacher = teachersRepository.save(teachers);

//        convert entity to dto
        TeachersDto teacherResponse = new TeachersDto();
        teacherResponse.setId(newTeacher.getId());
        teacherResponse.setDOB(newTeacher.getDOB());
        teacherResponse.setName(newTeacher.getName());
        teacherResponse.setFatherName(newTeacher.getFatherName());
        teacherResponse.setAddress(newTeacher.getAddress());
        teacherResponse.setEmailId(newTeacher.getEmailId());
        teacherResponse.setAadharCardNumber(newTeacher.getAadharCardNumber());
        teacherResponse.setMobileNumber(newTeacher.getMobileNumber());

        return teacherResponse;

    }
}
