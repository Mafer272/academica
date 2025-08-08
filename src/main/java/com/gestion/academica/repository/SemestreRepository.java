package com.gestion.academica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.academica.entity.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    
    
    Optional<Semestre> findByPeriodo(String periodo);
    
    
    List<Semestre> findByCiclo(String ciclo);
    
    
    Optional<Semestre> findByPeriodoAndCiclo(String periodo, String ciclo);
}