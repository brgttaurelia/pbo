/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.repository;

/**
 * Interface ini merupakan turunan dari class bawaan java yaitu JpaRepository 
 * Interface ini berguna untuk mengakses tabel tbl_student yang sudah dibuat di class Student beserta isi datanya
 * @author Brigitta Aurelia Putri Suhendi
 */

/**
JpaRespository adalah interface yang disediakan spring Data JPA framework dalam spring framework yang memiliki method-method bawaan seperti create,update,delete,dan retrieve tanpa menulis implementasi secara manual 
*/

import com.brigittaaurelia.studentdemocrudwebapp.entity.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student> findByLastName(String lastName);
}
