package com.portafolio.PortafolioWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Entity.Persona;
import com.portafolio.PortafolioWeb.Interface.IPersonaService;
import com.portafolio.PortafolioWeb.Repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);        
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);        
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return persona;
    }
}