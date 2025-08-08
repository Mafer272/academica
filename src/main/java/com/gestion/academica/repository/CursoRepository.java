package com.gestion.academica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.academica.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    
    List<Curso> findByProfesor(Long profesorId);
    
    
    List<Curso> findByMateriaContainingIgnoreCase(String materia);
    
    
    List<Curso> findByCreditos(Integer creditos);
}