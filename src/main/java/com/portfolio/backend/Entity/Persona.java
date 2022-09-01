package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1,max=50, message="no cumple con la longuitud")
    private String name;
    
    @NotNull
    @Size(min=1,max=50, message="no cumple con la longuitud")
    private String lastName;
    
    @NotNull
    @Size(min=1,max=50, message="no cumple con la longuitud")
    private String profession;
    
    @Size(min=1,max=50, message="no cumple con la longuitud")
    private String ubication;
    
    @Size(min=1,max=500, message="no cumple con la longuitud")
    private String aboutMe;
   
    @Size(min=1,max=50, message="no cumple con la longuitud")
    private String url_img;
    
     @Size(min=1,max=50, message="no cumple con la longuitud")
    private String url_backimg;  
}


 

