package com.gestion.academica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.academica.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
    
    Optional<Estudiante> findByCarnet(String carnet);
    
    
    boolean existsByCarnet(String carnet);
}