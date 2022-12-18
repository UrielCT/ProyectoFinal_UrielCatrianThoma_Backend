package com.portafolio.PortafolioWeb.Dto;

import jakarta.validation.constraints.NotBlank;

public class PersonaDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion; 
    @NotBlank
    private String img;


    public PersonaDTO() {
    }


    public PersonaDTO(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String descripcion,
            @NotBlank String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }

    
}
