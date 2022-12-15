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

import com.portafolio.PortafolioWeb.Dto.SkillsDTO;
import com.portafolio.PortafolioWeb.Entity.Skills;
import com.portafolio.PortafolioWeb.Security.Controller.Mensaje;
import com.portafolio.PortafolioWeb.Service.SkillsService;

@RestController
@RequestMapping("skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    
    @Autowired
    SkillsService skillsServ;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }





    @PostMapping("/create")
    public ResponseEntity<Skills> create(@RequestBody SkillsDTO skillsDTO) {
        if (StringUtils.isBlank(skillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillsServ.existsByNombre(skillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skill = new Skills(skillsDTO.getNombre(), skillsDTO.getPorcentaje());
        skillsServ.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }





    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsDTO skillsDTO) {
        //Validamos si existe el ID
        if (!skillsServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (skillsServ.existsByNombre(skillsDTO.getNombre()) && skillsServ.getByNombre(skillsDTO.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(skillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skill = skillsServ.getOne(id).get();
        skill.setNombre(skillsDTO.getNombre());
        skill.setPorcentaje(skillsDTO.getPorcentaje());

        skillsServ.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        }
        skillsServ.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }




    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skillsServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skill = skillsServ.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }






    



}
