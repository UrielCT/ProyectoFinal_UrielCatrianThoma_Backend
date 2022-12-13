package com.portafolio.PortafolioWeb.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Security.Entity.Rol;
import com.portafolio.PortafolioWeb.Security.Enums.RolNombre;
import com.portafolio.PortafolioWeb.Security.Repository.IRolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}