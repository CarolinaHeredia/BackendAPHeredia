
package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.Experiencia;
import com.portfolio.backend.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository iExperienciaRepository ;
    
   
    public List<Experiencia> list(){
        return iExperienciaRepository.findAll();
    }
    
     public Optional<Experiencia> getOne(int id){
        return iExperienciaRepository.findById(id);
    }
     
      public Optional<Experiencia> getByCompany(String company){
        return iExperienciaRepository.findByCompany(company);
      }
    
     
    public Optional<Experiencia> findByCompany(String company){
        return iExperienciaRepository.findByCompany(company);
    }
    
     
       
    public void saveExperiencia(Experiencia experiencia) {
     iExperienciaRepository.save(experiencia);
    }

 
    public void deleteExperiencia(int id) {
      iExperienciaRepository.deleteById(id);
    }

    
    public Experiencia findExperiencia(int id){
        Experiencia experiencia = iExperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
    
    public boolean existsById(int id){
      return  iExperienciaRepository.existsById(id);
    }
    
     public boolean existsByCompany(String company){
      return  iExperienciaRepository.existsByCompany(company);
    }  
}
