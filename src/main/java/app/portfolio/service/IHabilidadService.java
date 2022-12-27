package app.portfolio.service;

import app.portfolio.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> getHabilidades();
    
    public void saveHabilidad(Habilidad hab);
    
    public void deleteHabilidad(int id);
    
    public Habilidad findHabilidad(int id);
}