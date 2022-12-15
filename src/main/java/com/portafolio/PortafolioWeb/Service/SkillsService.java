package com.portafolio.PortafolioWeb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.PortafolioWeb.Entity.Skills;
import com.portafolio.PortafolioWeb.Repository.SkillsRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class SkillsService {
    @Autowired
    SkillsRepository skillsRepo;
    
    public List<Skills> list(){
        return skillsRepo.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return skillsRepo.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre){
        return skillsRepo.findByNombre(nombre);
    }
    
    public void save(Skills skill){
        skillsRepo.save(skill);
    }
    
    public void delete(int id){
        skillsRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillsRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return skillsRepo.existsByNombre(nombre);
    }
}
