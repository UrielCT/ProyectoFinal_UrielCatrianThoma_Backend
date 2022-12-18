package com.portafolio.PortafolioWeb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String fechaReali;
    private String link;
    private String imagen;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String fechaReali, String link, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaReali = fechaReali;
        this.link = link;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
