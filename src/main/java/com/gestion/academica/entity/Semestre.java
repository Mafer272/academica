package com.gestion.academica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "semestre")
public class Semestre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  
    
    @Column(name = "periodo", nullable = false, length = 20)
    private String periodo;
    
    @Column(name = "ciclo", nullable = false, length = 10)
    private String ciclo;
    
    
    public Semestre() {}
    
    
    public Semestre(String periodo, String ciclo) {
        this.periodo = periodo;
        this.ciclo = ciclo;
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
}