package com.example.schoolapplication.service;

import com.example.schoolapplication.entity.Student;
import com.example.schoolapplication.xml.school.ResponseDto;
import com.example.schoolapplication.xml.school.StudentRequest;
import com.example.schoolapplication.xml.school.StudentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static int counter = 0;

    public ResponseDto create(StudentRequest studentRequest) {
        Student student = new Student();
        BeanUtils.copyProperties(studentRequest, student);
        student.setId(++counter);
        studentList.add(student);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        responseDto.setMessage("Student is created successfully");
        return responseDto;
    }

    public ResponseDto findById(Integer id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        Student student = studentList.stream().filter(it -> it.getId() == id).findFirst().get();
         StudentResponse studentResponse=new StudentResponse();
        BeanUtils.copyProperties(student,studentResponse);
        responseDto.setData(studentResponse);
        return responseDto;
    }
}
