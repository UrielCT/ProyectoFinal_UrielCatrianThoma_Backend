package com.portafolio.PortafolioWeb.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.PortafolioWeb.Security.Entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
