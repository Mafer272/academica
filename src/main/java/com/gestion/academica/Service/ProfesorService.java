package com.gestion.academica.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.academica.entity.Profesor;
import com.gestion.academica.repository.ProfesorRepository;

@Service
public class ProfesorService {
    
    @Autowired
    private ProfesorRepository profesorRepository;
    
   
    public Profesor crearProfesor(Profesor profesor) {
       
        if (profesorRepository.existsByCorreo(profesor.getCorreo())) {
            throw new RuntimeException("Ya existe un profesor con el correo: " + profesor.getCorreo());
        }
        return profesorRepository.save(profesor);
    }
    
  
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }
    
    
    public Optional<Profesor> obtenerProfesorPorId(Integer id) {
        return profesorRepository.findById(id);
    }
    
    
    public Profesor actualizarProfesor(Integer id, Profesor profesorActualizado) {
        return profesorRepository.findById(id)
                .map(profesor -> {
                   
                    if (!profesor.getCorreo().equals(profesorActualizado.getCorreo()) &&
                         profesorRepository.existsByCorreo(profesorActualizado.getCorreo())) {
                        throw new RuntimeException("Ya existe un profesor con el correo: " + profesorActualizado.getCorreo());
                    }
                    
                    profesor.setNombre(profesorActualizado.getNombre());
                    profesor.setCorreo(profesorActualizado.getCorreo());
                    return profesorRepository.save(profesor);
                })
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
    }
    
    
    public void eliminarProfesor(Integer id) {
        if (!profesorRepository.existsById(id)) {
            throw new RuntimeException("Profesor no encontrado con ID: " + id);
        }
        profesorRepository.deleteById(id);
    }
    
    
    public Optional<Profesor> obtenerProfesorPorCorreo(String correo) {
        return profesorRepository.findByCorreo(correo);
    }
}