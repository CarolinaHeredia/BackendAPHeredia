
package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.Persona;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
    //traer una lista de persona
    public List<Persona> getpersona();
    
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar persona pero lo buscamos por Id
    public void deletePersona(Long id);
    
    //buscar una persona por Id
    public Persona findPersona(Long id);  
    
    public Optional<Persona> getOne(long id);
}
