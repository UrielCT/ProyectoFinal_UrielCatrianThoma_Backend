package com.portafolio.PortafolioWeb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolio.PortafolioWeb.Entity.Proyecto;
import com.portafolio.PortafolioWeb.Repository.ProyectoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepo;
    
    public List<Proyecto> list(){
        return proyectoRepo.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return proyectoRepo.findById(id);
    }
    
    public Optional<Proyecto> getByNmbre(String nombre){
        return proyectoRepo.findByNombre(nombre);
    }
    
    public void save(Proyecto proyecto){
        proyectoRepo.save(proyecto);
    }
    
    public void delete(int id){
        proyectoRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectoRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return proyectoRepo.existsByNombre(nombre);
    }
}
