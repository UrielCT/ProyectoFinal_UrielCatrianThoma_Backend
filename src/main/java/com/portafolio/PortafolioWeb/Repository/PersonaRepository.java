package com.portafolio.PortafolioWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.PortafolioWeb.Entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{
    
}
