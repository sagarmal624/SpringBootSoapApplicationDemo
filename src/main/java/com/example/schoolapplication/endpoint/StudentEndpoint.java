package com.example.schoolapplication.endpoint;

import com.example.schoolapplication.service.StudentService;
import com.example.schoolapplication.xml.school.ResponseDto;
import com.example.schoolapplication.xml.school.StudentFindByIdRequest;
import com.example.schoolapplication.xml.school.StudentRequest;
import com.example.schoolapplication.xml.school.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {
    @Autowired
    private StudentService studentService;

    @ResponsePayload
    @PayloadRoot(namespace = "http://www.example.com/schoolapplication/xml/school", localPart = "StudentRequest")
    public ResponseDto createStudent(@RequestPayload StudentRequest studentRequest) {
        return studentService.create(studentRequest);
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://www.example.com/schoolapplication/xml/school", localPart = "StudentFindByIdRequest")
    public ResponseDto getStudent(@RequestPayload StudentFindByIdRequest studentFindByIdRequest) {
        return studentService.findById(studentFindByIdRequest.getId());
    }
}
