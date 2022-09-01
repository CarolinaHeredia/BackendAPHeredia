
package com.portfolio.backend.Dto;

import java.util.logging.Logger;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter 
public class dtoProyecto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String buildingDate;
    @NotBlank
    private String link;
    @NotBlank
    private String url_img;
  
    
    //Constructores
    public dtoProyecto() {
    }

    public dtoProyecto(String name, String description, String buildingDate, String link, String url_img) {
        this.name = name;
        this.description = description;
        this.buildingDate = buildingDate;
        this.link = link;
        this.url_img = url_img;
    }
    
}