package app.portfolio.controller;

import app.portfolio.model.Proyecto;
import app.portfolio.service.IProyectoService;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-angular-c52b2.firebaseapp.com"})
public class ProyectoController {
    @Autowired
    private IProyectoService service;
    
    @GetMapping("proyectos/traer")
    @ResponseBody
    public List<Proyecto> traerProyectos(){
        return service.getProyectos();
    }
    
    @PostMapping("proyectos/crear")
    public String crearProyecto(@RequestBody Proyecto pro){
        service.saveProyecto(pro);
        return "Proyecto creado";
    }
    
    @DeleteMapping("proyectos/borrar/{id}")
    public String borrarProyecto(@PathVariable int id){
        service.deleteProyecto(id);
        return "Proyecto borrado";
    }
    
    @PutMapping("proyectos/editar/{id}")
    public Proyecto editarProyecto(@PathVariable int id,
                                   @RequestParam ("nombre") String nombre,
                                   @RequestParam ("descripcion") String descripcion,
                                   @RequestParam ("link") String link,
                                   @RequestParam ("url_img") String url_img,
                                   @RequestParam ("persona_id") int persona_id)
    {
        Proyecto pro = service.findProyecto(id);
        
        pro.setNombre(nombre);
        pro.setDescripcion(descripcion);
        pro.setLink(link);
        pro.setUrl_img(url_img);
        pro.setPersona_id(persona_id);
        
        service.saveProyecto(pro);
        
        return pro;
    }
}
