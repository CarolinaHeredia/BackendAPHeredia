
package com.portfolio.backend.Dto;


import java.util.logging.Logger;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter 

public class dtoExperiencia {

    
    @NotBlank
    private String company;
    @NotBlank
    private String position;
    @NotBlank
    private String description;
    @NotBlank
    private String img_url;
    @Setter @Getter 
    @NotBlank
    private String mode;
    @NotBlank
    private String start;
    @NotBlank
    private String end; 
    @NotBlank
    private String timeElapsed;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String company, String position, String description, String img_url, String mode, String start, String end, String timeElapsed) {
        this.company = company;
        this.position = position;
        this.description = description;
        this.img_url = img_url;
        this.mode = mode;
        this.start = start;
        this.end = end;
        this.timeElapsed = timeElapsed;
    }
}