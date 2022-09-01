
package com.portfolio.backend.Dto;
import java.util.logging.Logger;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter 

public class dtoEducacion {

    
    @NotBlank
    private String school;
    @NotBlank
    private String title;
    @NotBlank
    private String url_img;
    @NotBlank
    private String score;
    @NotBlank
    private String start;
    @NotBlank
    private String end; 
 
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String school, String title, String url_img, String score, String start) {
        this.school = school;
        this.title = title;
        this.url_img = url_img;
        this.score = score;
        this.start = start;
    }

 
}