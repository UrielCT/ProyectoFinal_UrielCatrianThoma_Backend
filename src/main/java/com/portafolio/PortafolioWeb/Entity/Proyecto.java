package com.portafolio.PortafolioWeb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "la longitud no es correcta")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 250, message = "la longitud no es correcta")
    private String descripcion;
    @NotNull
    @Size(min = 1, max = 50, message = "la longitud no es correcta")
    private String fechaReali;
    @NotNull
    @Size(min = 1, max = 50, message = "la longitud no es correcta")
    private String link;
    @NotNull
    @Size(min = 1, max = 50, message = "la longitud no es correcta")
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
}
