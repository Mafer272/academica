package com.gestion.academica.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gestion.academica.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    Optional<Estudiante> findByCarnet(String carnet);
    boolean existsByCarnet(String carnet);

    
    List<Estudiante> findByApellidoContainingIgnoreCase(String apellido);
    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);

    
    @Query("SELECT e FROM Estudiante e WHERE " +
           "(:nombre IS NULL OR LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
           "(:apellido IS NULL OR LOWER(e.apellido) LIKE LOWER(CONCAT('%', :apellido, '%'))) AND " +
           "(:carnet IS NULL OR LOWER(e.carnet) LIKE LOWER(CONCAT('%', :carnet, '%')))")
    List<Estudiante> findByNombreAndApellidoAndCarnetFilters(
        @Param("nombre") String nombre,
        @Param("apellido") String apellido,
        @Param("carnet") String carnet
    );
}