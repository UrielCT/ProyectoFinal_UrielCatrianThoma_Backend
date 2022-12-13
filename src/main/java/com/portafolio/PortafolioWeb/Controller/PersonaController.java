package com.portafolio.PortafolioWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.PortafolioWeb.Entity.Persona;
import com.portafolio.PortafolioWeb.Interface.IPersonaService;

@RestController
public class PersonaController {
    @Autowired IPersonaService iPersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return iPersonaService.getPersonas();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("img") String nuevaImg){

        Persona persona = iPersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);

        iPersonaService.savePersona(persona);

        return persona;

    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long) 3);
    }

}
