package app.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private String link;
    private String url_img;
    private int persona_id;

    public Proyecto() {
    }

    public Proyecto(int id, String nombre, String descripcion, String link, String url_img, int persona_id) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.url_img = url_img;
        this.persona_id = persona_id;
    }
    
}
