package com.example.schoolapplication.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

@Data
public class Student {
    private int id;
    private String name;
    private int standard;
    private String address;
}
