package com.gestion.academica.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.academica.dto.ReporteCursosPorProfesorDTO;
import com.gestion.academica.dto.ReporteNotaPromedioCursoDTO;
import com.gestion.academica.dto.ReporteEstudiantesPorCicloDTO;
import com.gestion.academica.dto.ReporteTopCursosDTO;
import com.gestion.academica.repository.ReporteRepository;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<ReporteCursosPorProfesorDTO> obtenerCursosPorProfesor() {
        return reporteRepository.obtenerCursosPorProfesor();
    }

    public List<ReporteNotaPromedioCursoDTO> obtenerNotaPromedioPorCurso() {
        return reporteRepository.obtenerNotaPromedioPorCurso();
    }

    public List<ReporteEstudiantesPorCicloDTO> obtenerEstudiantesPorCiclo() {
        return reporteRepository.obtenerEstudiantesPorCiclo();
    }

    public List<ReporteTopCursosDTO> obtenerTop3CursosPorNota() {
        List<ReporteTopCursosDTO> todosLosCursos = reporteRepository.obtenerTopCursosPorNota();
        // Limitar a los primeros 3 cursos
        return todosLosCursos.size() > 3 ? todosLosCursos.subList(0, 3) : todosLosCursos;
    }
}