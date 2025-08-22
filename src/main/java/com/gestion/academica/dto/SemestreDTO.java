package com.gestion.academica.dto;

public class SemestreDTO {
    private Integer id;
    private String periodo;
    private String ciclo;
    private String descripcion;

    public SemestreDTO() {}

    public SemestreDTO(Integer id, String periodo, String ciclo) {
        this.id = id;
        this.periodo = periodo;
        this.ciclo = ciclo;
        this.descripcion = periodo + " - " + ciclo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}