package com.gestion.academica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.gestion.academica.dto.ReporteCursosPorProfesorDTO;
import com.gestion.academica.dto.ReporteNotaPromedioCursoDTO;
import com.gestion.academica.dto.ReporteEstudiantesPorCicloDTO;
import com.gestion.academica.dto.ReporteTopCursosDTO;
import com.gestion.academica.entity.Inscripcion;

@Repository
public interface ReporteRepository extends JpaRepository<Inscripcion, Integer> {

    
    @Query("SELECT NEW com.gestion.academica.dto.ReporteCursosPorProfesorDTO(" +
           "p.nombre, COUNT(c)) " +
           "FROM Curso c " +
           "JOIN Profesor p ON c.profesor = p.id " +
           "GROUP BY p.id, p.nombre " +
           "ORDER BY COUNT(c) DESC")
    List<ReporteCursosPorProfesorDTO> obtenerCursosPorProfesor();

    
    @Query("SELECT NEW com.gestion.academica.dto.ReporteNotaPromedioCursoDTO(" +
           "c.materia, AVG(i.notaFinal)) " +
           "FROM Inscripcion i " +
           "JOIN Curso c ON i.curso = c.id " +
           "WHERE i.notaFinal IS NOT NULL " +
           "GROUP BY c.id, c.materia " +
           "ORDER BY c.materia")
    List<ReporteNotaPromedioCursoDTO> obtenerNotaPromedioPorCurso();

    
    @Query("SELECT NEW com.gestion.academica.dto.ReporteEstudiantesPorCicloDTO(" +
           "s.ciclo, COUNT(DISTINCT i.estudiante)) " +
           "FROM Inscripcion i " +
           "JOIN Semestre s ON i.semestre = s.id " +
           "GROUP BY s.ciclo " +
           "ORDER BY s.ciclo")
    List<ReporteEstudiantesPorCicloDTO> obtenerEstudiantesPorCiclo();

    
    @Query("SELECT NEW com.gestion.academica.dto.ReporteTopCursosDTO(" +
           "c.materia, AVG(i.notaFinal)) " +
           "FROM Inscripcion i " +
           "JOIN Curso c ON i.curso = c.id " +
           "WHERE i.notaFinal IS NOT NULL " +
           "GROUP BY c.id, c.materia " +
           "ORDER BY AVG(i.notaFinal) DESC")
    List<ReporteTopCursosDTO> obtenerTopCursosPorNota();
}