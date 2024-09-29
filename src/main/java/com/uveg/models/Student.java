package com.uveg.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    public Student(){
    }//constructor

    public Student(Long id, String nombre, String email, Date fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaNac = fechaNac;
    }//constructor

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
}//clase Student

