package com.portafolio.PortafolioWeb.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fechaReali;
    @NotBlank
    private String link;
    @NotBlank
    private String imagen;

    public ProyectoDTO() {}

    public ProyectoDTO(@NotBlank String nombre, @NotBlank String descripcion, String fechaReali, String link, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaReali = fechaReali;
        this.link = link;
        this.imagen = imagen;
    }
}
