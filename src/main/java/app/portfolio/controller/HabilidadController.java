package app.portfolio.controller;

import app.portfolio.model.Habilidad;
import app.portfolio.service.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-angular-c52b2.firebaseapp.com"})
public class HabilidadController {
    @Autowired
    private IHabilidadService service;
    
    @GetMapping("habilidades/traer")
    @ResponseBody
    public List<Habilidad> traerHabilidades(){
        return service.getHabilidades();
    }
    
    @PostMapping("habilidades/crear")
    public String crearHabilidad(@RequestBody Habilidad hab){
        service.saveHabilidad(hab);
        return "Habilidad creada";
    }
    
    @DeleteMapping("habilidades/borrar/{id}")
    public String borrarHabilidad(@PathVariable int id){
        service.deleteHabilidad(id);
        return "Habilidad borrada";
    }
}
