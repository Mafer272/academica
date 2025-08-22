package com.gestion.academica.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InscripcionDTO {
    private Integer id;
    private Integer estudianteId;
    private String nombreEstudiante;
    private String carnetEstudiante;
    private Integer cursoId;
    private String materia;
    private Integer semestreId;
    private BigDecimal notaFinal;
    private LocalDate fechaDeEvaluacion;
    private Integer creditos;

    public InscripcionDTO() {}

    public InscripcionDTO(Integer id, Integer estudianteId, String nombreEstudiante, 
                         String carnetEstudiante, Integer cursoId, String materia, 
                         Integer semestreId, BigDecimal notaFinal, 
                         LocalDate fechaDeEvaluacion, Integer creditos) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.nombreEstudiante = nombreEstudiante;
        this.carnetEstudiante = carnetEstudiante;
        this.cursoId = cursoId;
        this.materia = materia;
        this.semestreId = semestreId;
        this.notaFinal = notaFinal;
        this.fechaDeEvaluacion = fechaDeEvaluacion;
        this.creditos = creditos;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Integer semestreId) {
        this.semestreId = semestreId;
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}