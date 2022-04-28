package com.example.demoapplication;

import com.example.demoapplication.xml.school.StudentDetailsRequest;
import com.example.demoapplication.xml.school.StudentFindByIdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import com.example.demoapplication.xml.school.StudentDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndPoint {

    @Autowired
    private StudentRepository studentRepository;

    @ResponsePayload
    @PayloadRoot(namespace = "http://www.example.com/demoapplication/xml/school", localPart = "StudentDetailsRequest")
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest studentDetailsRequest) {
        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
        studentDetailsResponse.setStudent(studentRepository.findStudent(studentDetailsRequest.getName()));
        return studentDetailsResponse;
    }
    @ResponsePayload
    @PayloadRoot(namespace = "http://www.example.com/demoapplication/xml/school", localPart = "StudentFindByIdRequest")
    public StudentDetailsResponse getStudentById(@RequestPayload StudentFindByIdRequest studentFindByIdRequest) {
        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
        studentDetailsResponse.setStudent(studentRepository.findStudentById(studentFindByIdRequest.getId()));
        return studentDetailsResponse;
    }
}
