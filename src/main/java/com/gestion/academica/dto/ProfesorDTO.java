package com.gestion.academica.dto;

public class ProfesorDTO {
    private String nombre;
    private String correo;

    public ProfesorDTO(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
