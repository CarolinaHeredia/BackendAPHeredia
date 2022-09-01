
package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    //columna de la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String position;
    private String img_url;
    private String description;
    private String mode;
    private String start;
    private String end;
    private String timeElapsed;

    public Experiencia() {
    }

    public Experiencia(String company, String position, String description, String img_url,  String mode, String start, String end,String timeElapsed) {
        
        this.company = company;
        this.position = position;
        this.img_url = img_url;
        this.description = description;
        this.mode = mode;
        this.start = start;
        this.end = end;
         this.timeElapsed = timeElapsed;
    }
}