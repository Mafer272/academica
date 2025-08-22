package com.gestion.academica.dto;

public class CursoDTO {
    private String materia;
    private Integer creditos;
    private Integer profesorId;

    public CursoDTO(String materia, Integer creditos, Integer profesorId) {
        this.materia = materia;
        this.creditos = creditos;
        this.profesorId = profesorId;
    }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }

    public Integer getProfesorId() { return profesorId; }
    public void setProfesorId(Integer profesorId) { this.profesorId = profesorId; }
}
