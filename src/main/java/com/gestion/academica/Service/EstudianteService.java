package com.gestion.academica.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.academica.entity.Estudiante;
import com.gestion.academica.repository.EstudianteRepository;

@Service
public class EstudianteService {
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    
    public Estudiante crearEstudiante(Estudiante estudiante) {
        
        if (estudianteRepository.existsByCarnet(estudiante.getCarnet())) {
            throw new RuntimeException("Ya existe un estudiante con el carnet: " + estudiante.getCarnet());
        }
        return estudianteRepository.save(estudiante);
    }
    
    
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }
    
    
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id);
    }
    
    
    public Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                   
                    if (!estudiante.getCarnet().equals(estudianteActualizado.getCarnet()) && 
                        estudianteRepository.existsByCarnet(estudianteActualizado.getCarnet())) {
                        throw new RuntimeException("Ya existe un estudiante con el carnet: " + estudianteActualizado.getCarnet());
                    }
                    
                    estudiante.setCarnet(estudianteActualizado.getCarnet());
                    estudiante.setNombre(estudianteActualizado.getNombre());
                    estudiante.setApellido(estudianteActualizado.getApellido());
                    estudiante.setFechaDeNacimiento(estudianteActualizado.getFechaDeNacimiento());
                    return estudianteRepository.save(estudiante);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
    }
    
    
    public void eliminarEstudiante(Long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
        estudianteRepository.deleteById(id);
    }
    
    
    public Optional<Estudiante> obtenerEstudiantePorCarnet(String carnet) {
        return estudianteRepository.findByCarnet(carnet);
    }
}