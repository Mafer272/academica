package com.gestion.academica.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.academica.dto.CursoDTO;
import com.gestion.academica.entity.Curso;
import com.gestion.academica.repository.CursoRepository;
import com.gestion.academica.repository.ProfesorRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    public Curso crearCurso(Curso curso) {
        if (!profesorRepository.existsById(curso.getProfesor())) {
            throw new RuntimeException("No existe un profesor con ID: " + curso.getProfesor());
        }
        return cursoRepository.save(curso);
    }

    private CursoDTO convertirACursoDTO(Curso curso) {
        return new CursoDTO(curso.getMateria(), curso.getCreditos(), curso.getProfesor());
    }

    public List<CursoDTO> obtenerTodosLosCursosDTO() {
        return cursoRepository.findAll().stream()
                .map(this::convertirACursoDTO)
                .toList();
    }

    public Optional<CursoDTO> obtenerCursoPorIdDTO(Long id) {
        return cursoRepository.findById(id).map(this::convertirACursoDTO);
    }

    public List<CursoDTO> obtenerCursosPorProfesorDTO(Long profesorId) {
        return cursoRepository.findByProfesor(profesorId).stream()
                .map(this::convertirACursoDTO)
                .toList();
    }

    public List<CursoDTO> buscarCursosPorMateriaDTO(String materia) {
        return cursoRepository.findByMateriaContainingIgnoreCase(materia).stream()
                .map(this::convertirACursoDTO)
                .toList();
    }
}
