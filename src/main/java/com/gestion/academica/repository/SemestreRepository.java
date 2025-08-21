package com.gestion.academica.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gestion.academica.entity.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    Optional<Semestre> findByPeriodo(String periodo);
    List<Semestre> findByCiclo(String ciclo);
    Optional<Semestre> findByPeriodoAndCiclo(String periodo, String ciclo);

    
    List<Semestre> findByPeriodoContainingIgnoreCase(String periodo);

    
    @Query("SELECT s FROM Semestre s WHERE " +
           "(:periodo IS NULL OR LOWER(s.periodo) LIKE LOWER(CONCAT('%', :periodo, '%'))) AND " +
           "(:ciclo IS NULL OR LOWER(s.ciclo) LIKE LOWER(CONCAT('%', :ciclo, '%')))")
    List<Semestre> findByPeriodoAndCicloFilters(
        @Param("periodo") String periodo,
        @Param("ciclo") String ciclo
    );
}
