package app.portfolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private Date fecha_nac;
    private String acerca_de;
    private String correo;
    private String instagram;
    private String linkedin;
    private String github;
    private String url_foto;
    private String url_logo;
    private String url_banner;

    public Persona() {
    }

    public Persona(int id, String nombre, Date fecha_nac, String acerca_de, String correo, String instagram, String linkedin, String github, String url_foto, String url_logo, String url_banner) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.acerca_de = acerca_de;
        this.correo = correo;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.github = github;
        this.url_foto = url_foto;
        this.url_logo = url_logo;
        this.url_banner = url_banner;
    }
}
