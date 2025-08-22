package com.gestion.academica.repository;
//inscripcion
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gestion.academica.entity.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByEstudiante(Long estudianteId);
    List<Inscripcion> findByCurso(Long cursoId);
    List<Inscripcion> findBySemestre(Long semestreId);

    Optional<Inscripcion> findByEstudianteAndCursoAndSemestre(Long estudianteId, Long cursoId, Long semestreId);

    List<Inscripcion> findByNotaFinalIsNotNull();
    List<Inscripcion> findByNotaFinalIsNull();
    List<Inscripcion> findByNotaFinalGreaterThanEqual(BigDecimal nota);

    @Query("SELECT i FROM Inscripcion i WHERE i.estudiante = :estudianteId AND i.semestre = :semestreId")
    List<Inscripcion> findInscripcionesByEstudianteAndSemestre(
        @Param("estudianteId") Long estudianteId,
        @Param("semestreId") Long semestreId
    );

    @Query("SELECT AVG(i.notaFinal) FROM Inscripcion i WHERE i.estudiante = :estudianteId AND i.notaFinal IS NOT NULL")
    BigDecimal findPromedioByEstudiante(@Param("estudianteId") Long estudianteId);

    
    @Query("SELECT i FROM Inscripcion i WHERE " +
           "(:cursoId IS NULL OR i.curso = :cursoId) AND " +
           "(:semestreId IS NULL OR i.semestre = :semestreId) AND " +
           "(:notaMin IS NULL OR i.notaFinal >= :notaMin)")
    List<Inscripcion> findByCursoSemestreAndNotaFilters(
        @Param("cursoId") Long cursoId,
        @Param("semestreId") Long semestreId,
        @Param("notaMin") BigDecimal notaMin
    );
}
