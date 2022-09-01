package com.portfolio.backend.Controller;

import com.portfolio.backend.Dto.dtoPersona;
import com.portfolio.backend.Entity.Persona;
import com.portfolio.backend.Interface.IPersonaService;
import com.portfolio.backend.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/persona")
//@CrossOrigin(origins = "http://localhost:4200")


public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getpersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }

    // /personas/editar/4/name & firstname & jasjhdskad
   /* @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("name") String nuevoNombre,
     @RequestParam("lastName") String nuevoApellido, @RequestParam("profession") String nuevaProfesion,
     @RequestParam("ubication") String nuevaUbicacion,@RequestParam("aboutMe") String nuevaSobremi,
     @RequestParam("url_img") String nuevoUrl_img,@RequestParam("url_backimg") String nuevoUrl_backimg) {
        Persona persona = iPersonaService.findPersona(id);
        persona.setName(nuevoNombre);
        persona.setLastName(nuevoApellido);
        persona.setProfession(nuevaProfesion);
        persona.setUbication(nuevaUbicacion);
        persona.setAboutMe(nuevaSobremi);
        persona.setUrl_img(nuevoUrl_img);
        persona.setUrl_backimg(nuevoUrl_backimg);
        
        iPersonaService.savePersona(persona);
        return persona;
    }*/
    
      @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoper){
        //Validamos si existe el ID
      
        
        Persona persona = iPersonaService.getOne(id).get();
        
        persona.setName(dtoper.getName());
        persona.setLastName(dtoper.getLastName());
        persona.setProfession(dtoper.getProfession());
        persona.setUbication(dtoper.getUbication());
        persona.setAboutMe(dtoper.getAboutMe());   
        persona.setUrl_img(dtoper.getUrl_img());
        persona.setUrl_backimg(dtoper.getUrl_backimg());
        
       
        iPersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Persona actualizado"), HttpStatus.OK);
             
    }
    
    

    @GetMapping("/traer/perfil")
    public Persona findPersona() {
        return iPersonaService.findPersona((long)1);
    }

}


