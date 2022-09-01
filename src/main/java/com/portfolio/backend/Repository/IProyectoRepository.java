package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {

    public Optional<Proyecto> findByName(String name);

    public boolean existsByName(String name);
}
