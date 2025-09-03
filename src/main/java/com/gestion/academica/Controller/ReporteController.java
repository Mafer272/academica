package com.gestion.academica.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestion.academica.Service.ReporteService;
import com.gestion.academica.dto.ReporteCursosPorProfesorDTO;
import com.gestion.academica.dto.ReporteNotaPromedioCursoDTO;
import com.gestion.academica.dto.ReporteEstudiantesPorCicloDTO;
import com.gestion.academica.dto.ReporteTopCursosDTO;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    /**
     * Reporte 1: Número total de cursos que imparte cada profesor
     * GET /api/reportes/cursos-por-profesor
     */
    @GetMapping("/cursos-por-profesor")
    public ResponseEntity<List<ReporteCursosPorProfesorDTO>> obtenerCursosPorProfesor() {
        try {
            List<ReporteCursosPorProfesorDTO> reporte = reporteService.obtenerCursosPorProfesor();
            return new ResponseEntity<>(reporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Reporte 2: Nota promedio para cada curso
     * GET /api/reportes/nota-promedio-por-curso
     */
    @GetMapping("/nota-promedio-por-curso")
    public ResponseEntity<List<ReporteNotaPromedioCursoDTO>> obtenerNotaPromedioPorCurso() {
        try {
            List<ReporteNotaPromedioCursoDTO> reporte = reporteService.obtenerNotaPromedioPorCurso();
            return new ResponseEntity<>(reporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Reporte 3: Cantidad de estudiantes inscritos por cada ciclo académico
     * GET /api/reportes/estudiantes-por-ciclo
     */
    @GetMapping("/estudiantes-por-ciclo")
    public ResponseEntity<List<ReporteEstudiantesPorCicloDTO>> obtenerEstudiantesPorCiclo() {
        try {
            List<ReporteEstudiantesPorCicloDTO> reporte = reporteService.obtenerEstudiantesPorCiclo();
            return new ResponseEntity<>(reporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Reporte 4: Los 3 cursos con la nota promedio más alta
     * GET /api/reportes/top-3-cursos
     */
    @GetMapping("/top-3-cursos")
    public ResponseEntity<List<ReporteTopCursosDTO>> obtenerTop3CursosPorNota() {
        try {
            List<ReporteTopCursosDTO> reporte = reporteService.obtenerTop3CursosPorNota();
            return new ResponseEntity<>(reporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}