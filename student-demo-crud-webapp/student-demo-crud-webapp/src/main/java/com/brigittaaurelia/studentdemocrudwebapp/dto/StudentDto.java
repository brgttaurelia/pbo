/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brigittaaurelia.studentdemocrudwebapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Class ini berisi properties data yg diinput (kecuali createdOn dan updatedOn yang akan terisi secara otomatis saat membuat data baru atau mengupdate data yangs udah ada sebelumnya) beserta syarat pengisiannya
 * @author Brigitta Aurelia Putri Suhendi
 */

@Data
//Builder digunakan untuk memfasilitasi pembuatan objek yang kompleks dengan konfigurasi yang fleksibel dan mudah dibaca
//Builder digunakan untuk mengatasi masalah dalam membangun objek yang memiliki banyak atribut opsional atau yang nilainya dapat berubah-ubah
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    //agar id bersifat required atau harus terisi, jika tidak terisi maka tidak bisa tersubmit dan ada warning meessage
    @NotEmpty(message = "First Name should not be empty")
    private String firstName;
    //agar firstName bersifat required atau harus terisi, jika tidak terisi maka tidak bisa tersubmit dan ada warning meessage
    @NotEmpty(message = "Last Name should not be empty")
    private String lastName;
    //agar lastName bersifat required atau harus terisi, jika tidak terisi maka tidak bisa tersubmit dan ada warning meessage
    @NotNull(message = "Birth Date should not be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedOn;
}
