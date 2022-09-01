
package com.portfolio.backend.Dto;


import java.util.logging.Logger;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter 
public class dtoPersona {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String profession;
    @NotBlank
    private String ubication;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String url_img;
    @NotBlank
    private String url_backimg; 
  
    //Constructores

    public dtoPersona() {}

    public dtoPersona(String name, String lastName, String profession, String ubication, String url_img, String url_backimg) {
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
        this.ubication = ubication;
        this.url_img = url_img;
        this.url_backimg = url_backimg;
    }

}
    
   
  

