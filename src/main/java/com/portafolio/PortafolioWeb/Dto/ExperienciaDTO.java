package com.portafolio.PortafolioWeb.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String periodo; 
    @NotBlank
    private String img;


    public ExperienciaDTO() {}

    public ExperienciaDTO(String nombre, String descripcion, String periodo, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodo = periodo;
        this.img = img;
    }

}
