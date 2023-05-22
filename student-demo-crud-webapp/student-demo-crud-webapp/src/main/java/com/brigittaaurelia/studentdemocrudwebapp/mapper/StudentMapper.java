/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.mapper;

import com.brigittaaurelia.studentdemocrudwebapp.dto.StudentDto;
import com.brigittaaurelia.studentdemocrudwebapp.entity.Student;
        
/**
 * class yang berfungsi memetakan objek Student dengan StudentDto
 * Menggunakan method dalam kelas ini, kita dapat mengonversi antara objek Student dan StudentDto tanpa menuliskan kode boilerplate yang berulang
 * @author Brigitta Aurelia Putri Suhendi
 */
public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthDate(student.getBirthDate())
                .createdOn(student.getCreatedOn())
                .updatedOn(student.getUpdatedOn())
                .build();
        return studentDto;
    }
    
    public static Student mapToStudent(StudentDto studentDto){
        Student student = Student.builder()
                .id(studentDto.getId())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .birthDate(studentDto.getBirthDate())
                .createdOn(studentDto.getCreatedOn())
                .updatedOn(studentDto.getUpdatedOn())
                .build();
        return student;
    }
}
