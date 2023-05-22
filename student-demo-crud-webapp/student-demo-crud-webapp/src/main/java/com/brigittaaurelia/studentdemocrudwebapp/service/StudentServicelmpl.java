/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.service;

import com.brigittaaurelia.studentdemocrudwebapp.dto.StudentDto;
import com.brigittaaurelia.studentdemocrudwebapp.entity.Student;
import com.brigittaaurelia.studentdemocrudwebapp.mapper.StudentMapper;
import com.brigittaaurelia.studentdemocrudwebapp.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * class yang mengimplements semua abstract method interface StudentService
 * @author Brigitta Aurelia Putri Suhendi
 */

//untuk memisahkan logika bisnis dari lapisan presentasi (controller) dan lapisan penyimpanan data (repository)
//untuk menyediakan fungsi yang lebih tingkat di atas lapisan penyimpanan data
@Service
public class StudentServicelmpl implements StudentService{
    //properties
    private StudentRepository studentRepository;
    
    //constructor
    public StudentServicelmpl (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    
    //untuk mengambil nama-nama siswa yang sudah di create melalui class StudentMapper
    @Override
    public List<StudentDto> ambilDaftarStudent(){
        List<Student> students = this.studentRepository.findAll();
        
        List<StudentDto> studentDtos = students.stream()
                .map((student) -> (StudentMapper.mapToStudentDto(student)))
                .collect(Collectors.toList());
        return studentDtos;
    }
    
    //method untuk menghapus data student yang sudah di create
    @Override
    public void hapusDataStudent(Long studentId) {
        this.studentRepository.deleteById(studentId);
    }
    
    //method untuk memperbarui data student yang sudah di create
    @Override
    public void perbaruiDataStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        this.studentRepository.save(student);
    }
    
    //method untuk menyimpan data student
    @Override
    public void simpanDataStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }
    
    //method untuk memperbarui mencari id student yang dicari untuk dihapus
    @Override
    public StudentDto cariById(Long id){
        Student student = studentRepository.findById(id).orElse(null);
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }
}
