package com.portafolio.PortafolioWeb.Interface;

import java.util.List;

import com.portafolio.PortafolioWeb.Entity.Persona;

public interface IPersonaService {
    
    public List<Persona> getPersonas();

    public void savePersona(Persona persona);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);
}
