package com.gestion.academica.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestion.academica.Service.CursoService;
import com.gestion.academica.dto.CursoDTO;
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
    public ResponseEntity<List<CursoDTO>> obtenerTodosLosCursos() {
        return new ResponseEntity<>(cursoService.obtenerTodosLosCursosDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerCursoPorId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<CursoDTO>> obtenerCursosPorProfesor(@PathVariable Long profesorId) {
        return new ResponseEntity<>(cursoService.obtenerCursosPorProfesorDTO(profesorId), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CursoDTO>> buscarCursosPorMateria(@RequestParam String materia) {
        return new ResponseEntity<>(cursoService.buscarCursosPorMateriaDTO(materia), HttpStatus.OK);
    }
}
