package com.portafolio.PortafolioWeb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Entity.Educacion;
import com.portafolio.PortafolioWeb.Repository.EducacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository eduRepo;
    
    public List<Educacion> list(){
        return eduRepo.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return eduRepo.findById(id);
    }
    
    public Optional<Educacion> getByNmbreE(String nombreE){
        return eduRepo.findByNombreE(nombreE);
    }
    
    public void save(Educacion educacion){
        eduRepo.save(educacion);
    }
    
    public void delete(int id){
        eduRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return eduRepo.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return eduRepo.existsByNombreE(nombreE);
    }
}
