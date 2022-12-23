package com.portafolio.PortafolioWeb.Repository;


import org.springframework.stereotype.Repository;
import com.portafolio.PortafolioWeb.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia,Integer>{
    public Optional<Experiencia> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
