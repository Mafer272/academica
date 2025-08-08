package com.gestion.academica.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }
    
    
    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }
    
    
    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        return cursoRepository.findById(id)
                .map(curso -> {
                    
                    if (!profesorRepository.existsById(cursoActualizado.getProfesor())) {
                        throw new RuntimeException("No existe un profesor con ID: " + cursoActualizado.getProfesor());
                    }
                    
                    curso.setMateria(cursoActualizado.getMateria());
                    curso.setCreditos(cursoActualizado.getCreditos());
                    curso.setProfesor(cursoActualizado.getProfesor());
                    return cursoRepository.save(curso);
                })
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }
    
    
    public void eliminarCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }
        cursoRepository.deleteById(id);
    }
    
    
    public List<Curso> obtenerCursosPorProfesor(Long profesorId) {
        return cursoRepository.findByProfesor(profesorId);
    }
    
    public List<Curso> buscarCursosPorMateria(String materia) {
        return cursoRepository.findByMateriaContainingIgnoreCase(materia);
    }
}
