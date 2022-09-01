
package com.portfolio.backend.Repository;


import com.portfolio.backend.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Integer> {
    
    public Optional<Educacion> findBySchool(String company);
    public boolean existsBySchool(String school);
}