package app.portfolio.controller;

import app.portfolio.model.Experiencia;
import app.portfolio.service.IExperienciaService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolio-angular-c52b2.web.app", "https://portfolio-angular-c52b2.firebaseapp.com"})
public class ExperienciaController {
    @Autowired
    private IExperienciaService service;
    
    @GetMapping("experiencia/traer")
    @ResponseBody
    public List<Experiencia> traerExperiencia(){
        return service.getExperiencia();
    }
    
    @PostMapping("experiencia/crear")
    public String crearExperiencia(@RequestBody Experiencia exp){
        service.saveExperiencia(exp);
        return "Experiencia creada";
    }
    
    @DeleteMapping("experiencia/borrar/{id}")
    public String borrarExperiencia(@PathVariable int id){
        service.deleteExperiencia(id);
        return "Experiencia borrada";
    }
    
    @PutMapping("experiencia/editar/{id}")
    public Experiencia editarExperiencia(@PathVariable int id,
                                         @RequestParam ("empresa") String empresa,
                                         @RequestParam ("puesto") String puesto,
                                         @RequestParam ("descripcion") String desc,
                                         @RequestParam ("inicio") String inicio,
                                         @RequestParam ("fin") String fin,
                                         @RequestParam ("persona_id") int persona_id)
    {
        Experiencia exp = service.findExperiencia(id);
        
        if(!empresa.equals(""))
            exp.setEmpresa(empresa);
        if(!puesto.equals(""))
            exp.setPuesto(puesto);
        if(!desc.equals(""))
            exp.setDescripcion(desc);
        if(!inicio.equals(""))
            exp.setInicio(inicio);
        if(!fin.equals(""))
            exp.setFin(fin);
        exp.setPersona_id(persona_id);
        
        service.saveExperiencia(exp);
        return exp;
    }
}
