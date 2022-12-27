package app.portfolio.service;

import app.portfolio.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    
    public void savePersona(Persona perso);
    
    public void deletePersona(int id);
    
    public Persona findPersona(int id);
}