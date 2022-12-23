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
public class Experiencia {
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
    private String periodo;

    private String img;

    public Experiencia() {
    }

    public Experiencia(String nombre, String descripcion, String periodo, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodo = periodo;
        this.img = img;
    }

   

}
