package com.portafolio.PortafolioWeb.Dto;

import jakarta.validation.constraints.NotBlank;

public class ProyectoDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    
    private String fechaReali;
    private String link;
    private String imagen;



    public ProyectoDTO() {
    }

    public ProyectoDTO(@NotBlank String nombre, @NotBlank String descripcion, String fechaReali, String link, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaReali = fechaReali;
        this.link = link;
        this.imagen = imagen;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaReali() {
        return fechaReali;
    }

    public void setFechaReali(String fechaReali) {
        this.fechaReali = fechaReali;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
}
