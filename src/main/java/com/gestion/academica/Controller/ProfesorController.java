package com.gestion.academica.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestion.academica.Service.ProfesorService;
import com.gestion.academica.dto.ProfesorDTO;
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
    public ResponseEntity<List<ProfesorDTO>> obtenerTodosLosProfesores() {
        return new ResponseEntity<>(profesorService.obtenerTodosLosProfesoresDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerProfesorPorId(@PathVariable Integer id) {
        return profesorService.obtenerProfesorPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<ProfesorDTO> obtenerProfesorPorCorreo(@PathVariable String correo) {
        return profesorService.obtenerProfesorPorCorreoDTO(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
