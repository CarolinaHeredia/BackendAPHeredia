/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Skills;
import com.portfolio.backend.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    @Autowired
    ISkillsRepository iSkillsRepository ;
    
   
    public List<Skills> list(){
        return iSkillsRepository.findAll();
    }
    
     public Optional<Skills> getOne(int id){
        return iSkillsRepository.findById(id);
    }
     
      public Optional<Skills> getByName(String name){
        return iSkillsRepository.findByName(name);
      }
    
     
    public Optional<Skills> findByName(String name){
        return iSkillsRepository.findByName(name);
    }
    
     
       
    public void saveSkills(Skills skills) {
     iSkillsRepository.save(skills);
    }

 
    public void deleteSkills(int id) {
      iSkillsRepository.deleteById(id);
    }

    
    public Skills findSkills(int id){
        Skills skills = iSkillsRepository.findById(id).orElse(null);
        return skills;
    }
    
    public boolean existsById(int id){
      return  iSkillsRepository.existsById(id);
    }
    
     public boolean existsByName(String name){
      return  iSkillsRepository.existsByName(name);
    }  
}
