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
import org.springframework.web.bind.annotation.RestController;

import com.gestion.academica.Service.ProfesorService;
import com.gestion.academica.entity.Profesor;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    
    @Autowired
    private ProfesorService profesorService;
    
    @PostMapping
    public ResponseEntity<?> crearProfesor(@RequestBody Profesor profesor) {
        try {
            Profesor nuevoProfesor = profesorService.crearProfesor(profesor);
            return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodosLosProfesores() {
        List<Profesor> profesores = profesorService.obtenerTodosLosProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }
    
   
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Integer id) {
        return profesorService.obtenerProfesorPorId(id)
                .map(profesor -> ResponseEntity.ok(profesor))
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Integer id, @RequestBody Profesor profesor) {
        try {
            Profesor profesorActualizado = profesorService.actualizarProfesor(id, profesor);
            return new ResponseEntity<>(profesorActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Integer id) {
        try {
            profesorService.eliminarProfesor(id);
            return new ResponseEntity<>("Profesor eliminado exitosamente", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/correo/{correo}")
    public ResponseEntity<Profesor> obtenerProfesorPorCorreo(@PathVariable String correo) {
        return profesorService.obtenerProfesorPorCorreo(correo)
                .map(profesor -> ResponseEntity.ok(profesor))
                .orElse(ResponseEntity.notFound().build());
    }
}