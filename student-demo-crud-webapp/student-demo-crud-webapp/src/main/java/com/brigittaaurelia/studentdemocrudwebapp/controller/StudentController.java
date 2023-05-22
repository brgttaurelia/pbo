/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.controller;

import com.brigittaaurelia.studentdemocrudwebapp.dto.StudentDto;
import com.brigittaaurelia.studentdemocrudwebapp.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * class yang digunakan untuk menampung method-method yang akan digunakan
 * Pada framework Spring, controller berfungsi sebagai komponen yang menangani permintaan HTTP dari user dan mengatur logika bisnis serta koordinasi interaksi antara model dan tampilan
 * Controller berperan sebagai jembatan antara user dan aplikasi
 * @author Brigitta Aurelia Putri Suhendi
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    //constructor
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    //handler method, GET Request return model (dto) dan View (templates/*.html)
    //untuk mengambil seluruh data student (model)
    @GetMapping("/admin/students")
    public String students(Model model){
        List<StudentDto> studentDtos = this.studentService.ambilDaftarStudent();
        //tambah atribut "students" yang bisa/akan digunakan di view
        model.addAttribute("studentDtos", studentDtos);
        // thymeleaf view: "/templates/admin/studentd.html"
        return "/admin/students";
    }
    
    //handler method, GET Request return model (dto)
    //untuk menambahkan atribut studentDto dalam model
    @GetMapping("/admin/students/add")
    public String addStudentForm(Model model){
        StudentDto studentDto = new StudentDto();
        // tambah atribut "studentDto" yang bisa/akan digunakan di form th:object
        model.addAttribute("studentDto",studentDto);
        // thymeleaf view: "/templates/admin/students.html"
        return "/admin/student_add_form";
    }
    
    //handler method, POST Request return model (dto) dan View (templates/*.html)
    //untuk menambahkan atribut studentDto dalam model
    @PostMapping("/admin/students/add")
    public String addStudent(@Valid StudentDto studentDto, BindingResult result){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/student_add_form";
        }
        studentService.simpanDataStudent(studentDto);
        return "redirect:/admin/students";
    }
    
    //handler method, GET Request return model (dto) dan View (templates/*.html)
    //untuk menghapus data student
    @GetMapping("/admin/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.hapusDataStudent(id);
        return "redirect:/admin/students";
    }
    
    //handler method, GET Request return model (dto)
    //untuk mengupdate atribut studentDto dalam model
    @GetMapping("/admin/students/update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model){
        StudentDto studentDto = studentService.cariById(id);
        model.addAttribute("studentDto", studentDto);
        return "/admin/student_update_form";
    }
    
    //handler method, POST Request return model (dto) dan View (templates/*.html)
    //untuk mengupdate atribut studentDto dalam model
    @PostMapping("/admin/students/update")
    public String updateStudent(@Valid @ModelAttribute("studentDto") StudentDto studentDto, BindingResult result){
        if (result.hasErrors()){
            // model.addAttribute("studentDto", studentDto);
            return "/admin/student_update_form";
        }
        studentService.perbaruiDataStudent(studentDto);
        return "redirect:/admin/students";
    }
    
    //handler method untuk request view index
    @GetMapping("/")
    public String index () {
        return "index";
    }
}