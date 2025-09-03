package com.gestion.academica.dto;

public class ReporteCursosPorProfesorDTO {
    private String nombreProfesor;
    private Long totalCursos;

    public ReporteCursosPorProfesorDTO(String nombreProfesor, Long totalCursos) {
        this.nombreProfesor = nombreProfesor;
        this.totalCursos = totalCursos;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public Long getTotalCursos() {
        return totalCursos;
    }

    public void setTotalCursos(Long totalCursos) {
        this.totalCursos = totalCursos;
    }
}
