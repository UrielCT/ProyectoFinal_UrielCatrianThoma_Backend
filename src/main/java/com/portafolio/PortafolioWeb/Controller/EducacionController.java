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

import com.portafolio.PortafolioWeb.Dto.EducacionDTO;
import com.portafolio.PortafolioWeb.Entity.Educacion;
import com.portafolio.PortafolioWeb.Security.Controller.Mensaje;
import com.portafolio.PortafolioWeb.Service.EducacionService;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }





    @PostMapping("/create")
    public ResponseEntity<Educacion> create(@RequestBody EducacionDTO educacionDTO){
        if(StringUtils.isBlank(educacionDTO.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if(educacionService.existsByNombre(educacionDTO.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
            educacionDTO.getNombre(),
            educacionDTO.getDescripcion(),
            educacionDTO.getPeriodo(),
            educacionDTO.getImg());
        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }





    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDTO educacionDTO){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id not existe"), HttpStatus.BAD_REQUEST);
        }

        if(educacionService.existsByNombre(educacionDTO.getNombre()) && educacionService.getByNmbre(educacionDTO.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if(StringUtils.isBlank(educacionDTO.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombre(educacionDTO.getNombre());
        educacion.setDescripcion(educacionDTO.getDescripcion());
        
        educacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        educacionService.delete(id);

        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    



    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }




    
   
   
    
    
}
