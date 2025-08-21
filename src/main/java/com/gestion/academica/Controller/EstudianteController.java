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
import com.gestion.academica.Service.EstudianteService;
import com.gestion.academica.dto.EstudianteDTO;
import com.gestion.academica.entity.Estudiante;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;
    
    
    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
            return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudiante);
            return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable Integer id) {
        try {
            estudianteService.eliminarEstudiante(id);
            return new ResponseEntity<>("Estudiante eliminado exitosamente", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido) {
        
        try {
            List<EstudianteDTO> estudiantes;
            
            
            if (nombre != null || apellido != null) {
                estudiantes = estudianteService.filtrarEstudiantes(nombre, apellido);
            } else {
                estudiantes = estudianteService.obtenerTodosLosEstudiantesDTO();
            }
            
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Integer id) {
        return estudianteService.obtenerEstudiantePorIdDTO(id)
                .map(estudiante -> ResponseEntity.ok(estudiante))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/carnet/{carnet}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorCarnet(@PathVariable String carnet) {
        return estudianteService.obtenerEstudiantePorCarnetDTO(carnet)
                .map(estudiante -> ResponseEntity.ok(estudiante))
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @GetMapping("/buscar-apellido")
    public ResponseEntity<List<EstudianteDTO>> buscarEstudiantesPorApellido(@RequestParam String apellido) {
        List<EstudianteDTO> estudiantes = estudianteService.buscarEstudiantesPorApellido(apellido);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }
    
    @GetMapping("/buscar-nombre")
    public ResponseEntity<List<EstudianteDTO>> buscarEstudiantesPorNombre(@RequestParam String nombre) {
        List<EstudianteDTO> estudiantes = estudianteService.buscarEstudiantesPorNombre(nombre);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }
}