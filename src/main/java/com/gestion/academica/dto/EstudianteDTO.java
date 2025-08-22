package com.gestion.academica.dto;

public class EstudianteDTO {
    private String carnet;
    private String nombre;
    private String apellido;
    private int edad;

    public EstudianteDTO() {}

   
    public EstudianteDTO(String carnet, String nombre, String apellido, int edad) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    
    public String getCarnet() { 
        return carnet; 
    }
    
    public void setCarnet(String carnet) { 
        this.carnet = carnet; 
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getApellido() { 
        return apellido; 
    }
    
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    }

    public int getEdad() { 
        return edad; 
    }
    
    public void setEdad(int edad) { 
        this.edad = edad; 
    }
}