package app.portfolio.controller;

import app.portfolio.model.Educacion;
import app.portfolio.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired
    private IEducacionService service;
    
    @GetMapping("educacion/traer")
    public List<Educacion> traerEducacion(){
        return service.getEducacion();
    }
    
    @PostMapping("educacion/crear")
    public String crearEducacion(@RequestBody Educacion edu){
        service.saveEducacion(edu);
        return "Educación creada";
    }
    
    @DeleteMapping("educacion/borrar/{id}")
    public String borrarEducacion(@PathVariable int id){
       service.deleteEducacion(id);
       return "Educación eliminada";
    }
    
    @PutMapping("educacion/editar{id}")
    public Educacion editarEducacion(@PathVariable int id,
                                    @RequestParam ("nombre") String nombre,
                                    @RequestParam ("descripcion") String descripcion,
                                    @RequestParam ("inicio") int inicio,
                                    @RequestParam ("fin") int fin,
                                    @RequestParam ("persona_id") int persona_id)
    {
        Educacion edu = service.findEducacion(id);
        
        edu.setNombre(nombre);
        edu.setDescripcion(descripcion);
        edu.setInicio(inicio);
        edu.setFin(fin);
        edu.setPersona_id(persona_id);
        
        service.saveEducacion(edu);
        
        return edu;
    }
}
