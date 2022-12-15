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

import com.portafolio.PortafolioWeb.Dto.ExperienciaDTO;
import com.portafolio.PortafolioWeb.Entity.Experiencia;
import com.portafolio.PortafolioWeb.Security.Controller.Mensaje;
import com.portafolio.PortafolioWeb.Service.ExperienciaService;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }




    @PostMapping("/create")
    public ResponseEntity<Experiencia> create(@RequestBody ExperienciaDTO experienciaDTO){
        if(StringUtils.isBlank(experienciaDTO.getNombreExp())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if(experienciaService.existsByNombreExp(experienciaDTO.getNombreExp())){
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(experienciaDTO.getNombreExp(), experienciaDTO.getDescripcionExp());
        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }





    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDTO experienciaDTO){
        // valido si existe el id
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id not existe"), HttpStatus.BAD_REQUEST);
        }

        // compara nombre de experiencias
        if(experienciaService.existsByNombreExp(experienciaDTO.getNombreExp()) && experienciaService.getByNombreExp(experienciaDTO.getNombreExp()).get().getId() != id){
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        // no puede estar vacio
        if(StringUtils.isBlank(experienciaDTO.getNombreExp())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreExp(experienciaDTO.getNombreExp());
        experiencia.setDescripcionExp(experienciaDTO.getDescripcionExp());

        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia actualizado"), HttpStatus.OK);
    }




    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        // valida si existe el id
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        experienciaService.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
      




    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
