/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISkillsRepository extends JpaRepository<Skills,Integer> {
    
    public Optional<Skills> findByName(String name);
    public boolean existsByName(String name);
}
