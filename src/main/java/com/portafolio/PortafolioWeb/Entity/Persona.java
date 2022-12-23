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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "la longitud no es correcta")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "la longitud no es correcta")
    private String apellido;

    @NotNull
    private String descripcion; 
   
    private String img;

    public Persona() {}

    public Persona(@NotNull @Size(min = 1, max = 50, message = "la longitud no es correcta") String nombre,
            @NotNull @Size(min = 1, max = 50, message = "la longitud no es correcta") String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    
}
