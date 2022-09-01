package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoExperiencia;
import com.portfolio.backend.Entity.Experiencia;
import com.portfolio.backend.Security.Controller.Mensaje;
import com.portfolio.backend.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")


//@CrossOrigin(origins = "http://localhost:4200")

public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;
    
   @GetMapping("/lista")
   public ResponseEntity<List<Experiencia>> list(){
   List<Experiencia> list=experienciaService.list();
    return new ResponseEntity(list,HttpStatus.OK);
   }
   
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){      
        if(StringUtils.isBlank(dtoexp.getCompany()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByCompany(dtoexp.getCompany()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
 Experiencia experiencia = new Experiencia(dtoexp.getCompany(),dtoexp.getPosition(),dtoexp.getDescription(),
        dtoexp.getImg_url(),dtoexp.getMode(),dtoexp.getStart(),dtoexp.getEnd(),dtoexp.getTimeElapsed());
        experienciaService.saveExperiencia(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(experienciaService.existsByCompany(dtoexp.getCompany()) && experienciaService.getByCompany(dtoexp.getCompany()).get().getId() != id)
           return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getCompany()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setCompany(dtoexp.getCompany());
        experiencia.setPosition(dtoexp.getPosition());
        experiencia.setDescription(dtoexp.getDescription());
        experiencia.setImg_url(dtoexp.getImg_url());
        experiencia.setMode(dtoexp.getMode());
        experiencia.setStart(dtoexp.getStart());
        experiencia.setEnd(dtoexp.getEnd());
        experiencia.setTimeElapsed(dtoexp.getTimeElapsed());
        
        
        experienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
}
