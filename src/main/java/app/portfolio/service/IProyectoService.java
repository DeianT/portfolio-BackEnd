package app.portfolio.service;

import app.portfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> getProyectos();
    
    public void saveProyecto(Proyecto pro);
    
    public void deleteProyecto(int id);
    
    public Proyecto findProyecto(int id);
}
