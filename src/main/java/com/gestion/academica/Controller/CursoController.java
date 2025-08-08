package com.gestion.academica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.academica.Service.CursoService;
import com.gestion.academica.entity.Curso;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;
    
   
    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody Curso curso) {
        try {
            Curso nuevoCurso = cursoService.crearCurso(curso);
            return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
   
    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodosLosCursos() {
        List<Curso> cursos = cursoService.obtenerTodosLosCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
   
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id)
                .map(curso -> ResponseEntity.ok(curso))
                .orElse(ResponseEntity.notFound().build());
    }
    
   
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        try {
            Curso cursoActualizado = cursoService.actualizarCurso(id, curso);
            return new ResponseEntity<>(cursoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id) {
        try {
            cursoService.eliminarCurso(id);
            return new ResponseEntity<>("Curso eliminado exitosamente", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<Curso>> obtenerCursosPorProfesor(@PathVariable Long profesorId) {
        List<Curso> cursos = cursoService.obtenerCursosPorProfesor(profesorId);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Curso>> buscarCursosPorMateria(@RequestParam String materia) {
        List<Curso> cursos = cursoService.buscarCursosPorMateria(materia);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
}