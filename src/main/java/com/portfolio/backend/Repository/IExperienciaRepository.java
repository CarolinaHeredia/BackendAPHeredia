
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Integer> {
    
    public Optional<Experiencia> findByCompany(String company);
    public boolean existsByCompany(String company);
}
