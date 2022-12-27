package app.portfolio.service;

import app.portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> getExperiencia();
    
    public void saveExperiencia(Experiencia exp);
    
    public void deleteExperiencia(int id);
    
    public Experiencia findExperiencia(int id);
}