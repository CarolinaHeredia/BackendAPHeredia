
package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    //columna de la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String buildingDate;
    private String link;
    private String url_img;

    public Proyecto(String name, String description, String buildingDate, String link, String url_img) {
        this.name = name;
        this.description = description;
        this.buildingDate = buildingDate;
        this.link = link;
        this.url_img = url_img;
    }

    public Proyecto() {
    }
    
    
   
}
