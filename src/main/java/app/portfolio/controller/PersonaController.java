package app.portfolio.controller;

import app.portfolio.model.Persona;
import app.portfolio.service.IPersonaService;
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
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("personas/traer")
    @ResponseBody
    public List<Persona> traerPersonas(){
        return interPersona.getPersonas();
    }
    
    @PostMapping("personas/crear")
    public String crearPersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "Persona creada correctamente";
    }
    
    @DeleteMapping("personas/borrar/{id}")
    public String borrarPersona(@PathVariable int id){
        interPersona.deletePersona(id);
        return "Persona borrada";
    }
    
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable int id,
                                @RequestParam ("nombre") String nombre,
                                @RequestParam ("fecha_nac") String fecha_nac,
                                @RequestParam ("acerca_de") String acerca_de,
                                @RequestParam ("correo") String correo,
                                @RequestParam ("instagram") String instagram,
                                @RequestParam ("linkedin") String linkedin,
                                @RequestParam ("github") String github,
                                @RequestParam ("url_foto") String url_foto,
                                @RequestParam ("url_logo") String url_logo,
                                @RequestParam ("url_banner") String url_banner)
    {
        Persona perso = interPersona.findPersona(id);
        if (!"".equals(nombre))
            perso.setNombre(nombre);
        if (!"".equals(fecha_nac))
            perso.setFecha_nac(fecha_nac);
        if (!"".equals(acerca_de))
            perso.setAcerca_de(acerca_de);
        if (!"".equals(correo))
            perso.setCorreo(correo);
        if (!"".equals(instagram))
            perso.setInstagram(instagram);
        if (!"".equals(linkedin))
            perso.setLinkedin(linkedin);
        if (!"".equals(github))
            perso.setGithub(github);
        if (!"".equals(url_foto))
            perso.setUrl_foto(url_foto);
        if (!"".equals(url_logo))
            perso.setUrl_logo(url_logo);
        if (!"".equals(url_banner))
            perso.setUrl_banner(url_banner);
        
        interPersona.savePersona(perso);
        
        return perso;
    }
}