package com.gestion.academica.Service;
//profesor
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.academica.dto.ProfesorDTO;
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

    private ProfesorDTO convertirAProfesorDTO(Profesor profesor) {
        return new ProfesorDTO(profesor.getNombre(), profesor.getCorreo());
    }

    public List<ProfesorDTO> obtenerTodosLosProfesoresDTO() {
        return profesorRepository.findAll().stream()
                .map(this::convertirAProfesorDTO)
                .toList();
    }

    public Optional<ProfesorDTO> obtenerProfesorPorIdDTO(Integer id) {
        return profesorRepository.findById(id).map(this::convertirAProfesorDTO);
    }

    public Optional<ProfesorDTO> obtenerProfesorPorCorreoDTO(String correo) {
        return profesorRepository.findByCorreo(correo).map(this::convertirAProfesorDTO);
    }
}
