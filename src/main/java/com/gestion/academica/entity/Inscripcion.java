package com.gestion.academica.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  
    
    @Column(name = "nota_final", precision = 4, scale = 2)
    private BigDecimal notaFinal;
    
    @Column(name = "fecha_de_evaluacion")
    private LocalDate fechaDeEvaluacion;
    
    @Column(name = "semestre", nullable = false)
    private Integer semestre;  
    
    @Column(name = "estudiante", nullable = false)
    private Integer estudiante;  
    
    @Column(name = "curso", nullable = false)
    private Integer curso;  
    
    
    public Inscripcion() {}
    
    
    public Inscripcion(Integer semestre, Integer estudiante, Integer curso, BigDecimal notaFinal, LocalDate fechaDeEvaluacion) {
        this.semestre = semestre;
        this.estudiante = estudiante;
        this.curso = curso;
        this.notaFinal = notaFinal;
        this.fechaDeEvaluacion = fechaDeEvaluacion;
    }
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public BigDecimal getNotaFinal() {
        return notaFinal;
    }
    
    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    public LocalDate getFechaDeEvaluacion() {
        return fechaDeEvaluacion;
    }
    
    public void setFechaDeEvaluacion(LocalDate fechaDeEvaluacion) {
        this.fechaDeEvaluacion = fechaDeEvaluacion;
    }
    
    public Integer getSemestre() {
        return semestre;
    }
    
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
    
    public Integer getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Integer estudiante) {
        this.estudiante = estudiante;
    }
    
    public Integer getCurso() {
        return curso;
    }
    
    public void setCurso(Integer curso) {
        this.curso = curso;
    }
}
