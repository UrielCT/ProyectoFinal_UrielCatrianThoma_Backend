package com.portafolio.PortafolioWeb.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Security.Entity.Usuario;
import com.portafolio.PortafolioWeb.Security.Repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired 
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nuevoUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nuevoUsuario);
    }

    public boolean existsByNombreUsuario(String nuevoUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nuevoUsuario);
    }

    public boolean existsByEmail(String email) {
        return iUsuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
}