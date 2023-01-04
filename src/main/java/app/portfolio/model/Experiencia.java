package app.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String empresa;
    private String puesto;
    private String descripcion;
    private String inicio;
    private String fin;
    private int persona_id;

    public Experiencia() {
    }

    public Experiencia(int id, String empresa, String puesto, String descripcion, String inicio, String fin, int persona_id) {
        this.id = id;
        this.empresa = empresa;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.persona_id = persona_id;
    }   
}