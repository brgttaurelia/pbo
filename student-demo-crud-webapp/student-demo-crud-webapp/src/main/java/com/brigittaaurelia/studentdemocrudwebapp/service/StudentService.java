/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.service;

import com.brigittaaurelia.studentdemocrudwebapp.dto.StudentDto;
import java.util.List;

/**
 * interface yang akan diimplementasikan oleh class StudentServicelmpl yang berisi method-method yang akan diimplementasikan seluruhnya 
 * @author Brigitta Aurelia Putri Suhendi
 */
public interface StudentService {
    
    public List<StudentDto> ambilDaftarStudent();
    public void perbaruiDataStudent (StudentDto studentDto);
    public void hapusDataStudent (Long students);
    public void simpanDataStudent (StudentDto studentDto);
    public StudentDto cariById(Long id);
}
