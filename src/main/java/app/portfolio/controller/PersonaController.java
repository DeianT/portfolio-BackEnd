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
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-angular-c52b2.firebaseapp.com"})
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
        perso.setNombre(nombre);
        perso.setFecha_nac(fecha_nac);
        perso.setAcerca_de(acerca_de);
        perso.setCorreo(correo);
        perso.setInstagram(instagram);
        perso.setLinkedin(linkedin);
        perso.setGithub(github);
        perso.setUrl_foto(url_foto);
        perso.setUrl_logo(url_logo);
        perso.setUrl_banner(url_banner);
        
        interPersona.savePersona(perso);
        
        return perso;
    }
}