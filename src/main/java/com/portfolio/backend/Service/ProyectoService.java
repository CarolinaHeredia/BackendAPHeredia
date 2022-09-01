
package com.portfolio.backend.Service;
import com.portfolio.backend.Entity.Proyecto;
import com.portfolio.backend.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository iProyectoRepository ;
    
   
    public List<Proyecto> list(){
        return iProyectoRepository.findAll();
    }
    
     public Optional<Proyecto> getOne(int id){
        return iProyectoRepository.findById(id);
    }
     
      public Optional<Proyecto> getByName(String name){
        return iProyectoRepository.findByName(name);
      }
    
     
    public Optional<Proyecto> findByName(String name){
        return iProyectoRepository.findByName(name);
    }
    
     
       
    public void saveProyecto(Proyecto proyecto) {
     iProyectoRepository.save(proyecto);
    }

 
    public void deleteProyecto(int id) {
      iProyectoRepository.deleteById(id);
    }

    
    public Proyecto findProyecto(int id){
        Proyecto proyecto = iProyectoRepository.findById(id).orElse(null);
        return proyecto;
    }
    
    public boolean existsById(int id){
      return  iProyectoRepository.existsById(id);
    }
    
     public boolean existsByName(String name){
      return  iProyectoRepository.existsByName(name);
    }  
}
