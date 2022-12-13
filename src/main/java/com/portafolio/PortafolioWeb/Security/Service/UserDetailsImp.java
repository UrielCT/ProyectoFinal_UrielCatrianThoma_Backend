package com.portafolio.PortafolioWeb.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Security.Entity.Usuario;
import com.portafolio.PortafolioWeb.Security.Entity.UsuarioPrincipal;

@Service
public class UserDetailsImp implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(username).get();
        return UsuarioPrincipal.build(usuario);
    }

    
    
    
}
