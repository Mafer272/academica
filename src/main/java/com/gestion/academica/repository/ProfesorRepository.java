package com.gestion.academica.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gestion.academica.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    Optional<Profesor> findByCorreo(String correo);
    boolean existsByCorreo(String correo);

    
    List<Profesor> findByNombreContainingIgnoreCase(String nombre);

    
    @Query("SELECT p FROM Profesor p WHERE " +
           "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
           "(:correo IS NULL OR LOWER(p.correo) LIKE LOWER(CONCAT('%', :correo, '%')))")
    List<Profesor> findByNombreAndCorreoFilters(
        @Param("nombre") String nombre,
        @Param("correo") String correo
    );
}
