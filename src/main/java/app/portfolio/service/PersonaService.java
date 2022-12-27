package app.portfolio.service;

import app.portfolio.model.Persona;
import app.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(int id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        return persoRepo.findById(id).orElse(null);
    }
}