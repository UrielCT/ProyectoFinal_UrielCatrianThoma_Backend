package com.portafolio.PortafolioWeb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.portafolio.PortafolioWeb.Entity.Experiencia;
import com.portafolio.PortafolioWeb.Repository.ExperienciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombre(String nombre){
        return experienciaRepository.findByNombre(nombre);
    }

    public void save(Experiencia exp){
        experienciaRepository.save(exp);
    }

    public void delete(int id){
        experienciaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return experienciaRepository.existsByNombre(nombre);
    }
}
