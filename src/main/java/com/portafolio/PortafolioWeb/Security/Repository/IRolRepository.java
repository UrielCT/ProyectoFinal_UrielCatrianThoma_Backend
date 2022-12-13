package com.portafolio.PortafolioWeb.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.PortafolioWeb.Security.Entity.Rol;
import com.portafolio.PortafolioWeb.Security.Enums.RolNombre;

@Repository
public interface IRolRepository  extends JpaRepository<Rol,Long>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

