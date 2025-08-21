package com.gestion.academica.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.academica.dto.EstudianteDTO;
import com.gestion.academica.entity.Estudiante;
import com.gestion.academica.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Métodos existentes para entidades
    public Estudiante crearEstudiante(Estudiante estudiante) {
        if (estudianteRepository.existsByCarnet(estudiante.getCarnet())) {
            throw new RuntimeException("Ya existe un estudiante con el carnet: " + estudiante.getCarnet());
        }
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizarEstudiante(Integer id, Estudiante estudiante) {
        Optional<Estudiante> estudianteExistente = estudianteRepository.findById(id);
        if (estudianteExistente.isPresent()) {
            Estudiante estudianteActualizar = estudianteExistente.get();
            estudianteActualizar.setCarnet(estudiante.getCarnet());
            estudianteActualizar.setNombre(estudiante.getNombre());
            estudianteActualizar.setApellido(estudiante.getApellido());
            estudianteActualizar.setFechaDeNacimiento(estudiante.getFechaDeNacimiento());
            return estudianteRepository.save(estudianteActualizar);
        } else {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
    }

    public void eliminarEstudiante(Integer id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
    }

  
    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        int edad = 0; 
        if (estudiante.getFechaDeNacimiento() != null) {
            edad = Period.between(estudiante.getFechaDeNacimiento(), LocalDate.now()).getYears();
        }
        return new EstudianteDTO(
            estudiante.getCarnet(),
            estudiante.getNombre(),
            estudiante.getApellido(),
            edad
        );
    }

    
    public List<EstudianteDTO> obtenerTodosLosEstudiantesDTO() {
        return estudianteRepository.findAll().stream()
                .map(this::convertirAEstudianteDTO)
                .toList();
    }

    public Optional<EstudianteDTO> obtenerEstudiantePorIdDTO(Integer id) {
        return estudianteRepository.findById(id).map(this::convertirAEstudianteDTO);
    }

    public Optional<EstudianteDTO> obtenerEstudiantePorCarnetDTO(String carnet) {
        return estudianteRepository.findByCarnet(carnet).map(this::convertirAEstudianteDTO);
    }

    public List<EstudianteDTO> buscarEstudiantesPorApellido(String apellido) {
        return estudianteRepository.findByApellidoContainingIgnoreCase(apellido).stream()
                .map(this::convertirAEstudianteDTO)
                .toList();
    }

    public List<EstudianteDTO> buscarEstudiantesPorNombre(String nombre) {
        return estudianteRepository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(this::convertirAEstudianteDTO)
                .toList();
    }

    public List<EstudianteDTO> filtrarEstudiantes(String nombre, String apellido) {
        return estudianteRepository.findByNombreAndApellidoAndCarnetFilters(nombre, apellido, null).stream()
                .map(this::convertirAEstudianteDTO)
                .toList();
    }
}