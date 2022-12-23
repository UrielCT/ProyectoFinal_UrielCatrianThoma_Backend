package com.portafolio.PortafolioWeb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.PortafolioWeb.Entity.Educacion;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}