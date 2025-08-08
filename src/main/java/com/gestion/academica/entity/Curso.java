package com.gestion.academica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  
    
    @Column(name = "materia", nullable = false, length = 100)
    private String materia;
    
    @Column(name = "creditos", nullable = false)
    private Integer creditos;
    
    @Column(name = "profesor", nullable = false)
    private Integer profesor;  
    
    
    public Curso() {}
    
    
    public Curso(String materia, Integer creditos, Integer profesor) {
        this.materia = materia;
        this.creditos = creditos;
        this.profesor = profesor;
    }
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getMateria() {
        return materia;
    }
    
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    public Integer getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Integer profesor) {
        this.profesor = profesor;
    }
}
