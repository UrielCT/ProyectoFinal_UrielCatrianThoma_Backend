package com.portafolio.PortafolioWeb.Security.Entity;

import com.portafolio.PortafolioWeb.Security.Enums.RolNombre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;


    public Rol() {
    }
    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }



    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public RolNombre getRolNombre() {
        return rolNombre;
    }
    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    

    
}