/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter 
public class dtoSkills {

    @NotBlank
    private String name;
    @NotBlank
    private String progress;
    
    //Constructores

    public dtoSkills() {
    }

    
    public dtoSkills(String name, String progress) {
        this.name = name;
        this.progress = progress;
    }
 
    
}