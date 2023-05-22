/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.entity;

/**
 * class ini digunakan untuk membuat tabel yang berisi sesuai dengan data yang sudah diinput sebelumnya
 * @author Brigitta Aurelia Putri Suhendi
 */

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity 
@Table(name = "tbl_student") //kalau tidak di set maka nama tabel sesuai nama class

public class Student {
    @Id //anotasi dr hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //id tidak diizinkan untuk kosong atau NULL
    @Column(nullable = false)
    private String firstName;
    //fisrtName tidak diizinkan untuk kosong atau NULL
    @Column(nullable = false)
    private String lastName;
    //lastName tidak diizinkan untuk kosong atau NULL
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;
    //Date tidak diizinkan untuk kosong atau NULL
    @Column(nullable = false)
    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;
    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedOn;
}   
