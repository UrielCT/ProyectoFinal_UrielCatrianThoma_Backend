package com.portafolio.PortafolioWeb.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolio.PortafolioWeb.Entity.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer>{
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
