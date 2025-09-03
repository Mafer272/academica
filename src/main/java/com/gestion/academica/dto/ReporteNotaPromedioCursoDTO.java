package com.gestion.academica.dto;

import java.math.BigDecimal;

public class ReporteNotaPromedioCursoDTO {
    private String nombreCurso;
    private BigDecimal notaPromedio;

    public ReporteNotaPromedioCursoDTO(String nombreCurso, BigDecimal notaPromedio) {
        this.nombreCurso = nombreCurso;
        this.notaPromedio = notaPromedio;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public BigDecimal getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(BigDecimal notaPromedio) {
        this.notaPromedio = notaPromedio;
    }
}