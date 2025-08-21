package com.gestion.academica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gestion.academica.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    
    List<Curso> findByProfesor(Long profesorId);
    List<Curso> findByMateriaContainingIgnoreCase(String materia);
    List<Curso> findByCreditos(Integer creditos);

    
    @Query("SELECT c FROM Curso c WHERE " +
           "(:materia IS NULL OR LOWER(c.materia) LIKE LOWER(CONCAT('%', :materia, '%'))) AND " +
           "(:creditos IS NULL OR c.creditos = :creditos) AND " +
           "(:profesorId IS NULL OR c.profesor = :profesorId)")
    List<Curso> findByMateriaAndCreditosAndProfesorFilters(
        @Param("materia") String materia,
        @Param("creditos") Integer creditos,
        @Param("profesorId") Integer profesorId
    );

    
    @Query("SELECT c FROM Curso c JOIN Profesor p ON c.profesor = p.id WHERE " +
           "LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombreProfesor, '%'))")
    List<Curso> findByNombreProfesorContainingIgnoreCase(@Param("nombreProfesor") String nombreProfesor);
}
