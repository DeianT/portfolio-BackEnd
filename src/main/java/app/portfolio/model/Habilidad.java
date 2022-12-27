package app.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private int persona_id;

    public Habilidad() {
    }

    public Habilidad(int id, String nombre, int persona_id) {
        this.id = id;
        this.nombre = nombre;
        this.persona_id = persona_id;
    }
}
