package com.portafolio.PortafolioWeb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Entity.Persona;
import com.portafolio.PortafolioWeb.Repository.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonaService  {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> list(){
        return personaRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }

    public void save(Persona per){
        personaRepository.save(per);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return personaRepository.existsByNombre(nombre);
    }

    /*@Override
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
    }*/
}