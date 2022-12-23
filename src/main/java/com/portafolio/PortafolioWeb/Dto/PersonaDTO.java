package com.portafolio.PortafolioWeb.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PersonaDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion; 
    @NotBlank
    private String img;


    public PersonaDTO() {}


    public PersonaDTO(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String descripcion,
            @NotBlank String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }


    

    
}
