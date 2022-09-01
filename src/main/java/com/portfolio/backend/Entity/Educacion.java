
package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    //columna de la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String school;
    private String title;
    private String url_img;
    private String score;
    private String start;
    private String end;

    
    public Educacion() {
    }

    public Educacion(String school, String title, String url_img, String score, String start, String end) {
        this.school = school;
        this.title = title;
        this.url_img = url_img;
        this.score = score;
        this.start = start;
        this.end = end;
    }
 
}