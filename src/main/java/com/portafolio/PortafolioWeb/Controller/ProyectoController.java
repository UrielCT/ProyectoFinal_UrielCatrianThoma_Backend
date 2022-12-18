package com.portafolio.PortafolioWeb.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.PortafolioWeb.Dto.ProyectoDTO;
import com.portafolio.PortafolioWeb.Entity.Proyecto;
import com.portafolio.PortafolioWeb.Security.Controller.Mensaje;
import com.portafolio.PortafolioWeb.Service.ProyectoService;



@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }





    @PostMapping("/create")
    public ResponseEntity<Proyecto> create(@RequestBody ProyectoDTO proyectoDTO){
        if(StringUtils.isBlank(proyectoDTO.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if(proyectoService.existsByNombre(proyectoDTO.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
            proyectoDTO.getNombre(), 
            proyectoDTO.getDescripcion(), 
            proyectoDTO.getFechaReali(), 
            proyectoDTO.getLink(), 
            proyectoDTO.getImagen());
            
        proyectoService.save(proyecto);


        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }





    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDTO proyectoDTO){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id not existe"), HttpStatus.BAD_REQUEST);
        }

        if(proyectoService.existsByNombre(proyectoDTO.getNombre()) && proyectoService.getByNmbre(proyectoDTO.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(proyectoDTO.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setFechaReali(proyectoDTO.getFechaReali());
        proyecto.setLink(proyectoDTO.getLink());
        proyecto.setImagen(proyectoDTO.getImagen());
        
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        proyectoService.delete(id);

        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    



    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }



}
