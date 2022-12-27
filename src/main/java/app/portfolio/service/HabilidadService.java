package app.portfolio.service;

import app.portfolio.model.Habilidad;
import app.portfolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService{
    @Autowired
    private HabilidadRepository repo;

    @Override
    public List<Habilidad> getHabilidades() {
        return repo.findAll();
    }

    @Override
    public void saveHabilidad(Habilidad hab) {
        repo.save(hab);
    }

    @Override
    public void deleteHabilidad(int id) {
        repo.deleteById(id);
    }

    @Override
    public Habilidad findHabilidad(int id) {
        return repo.findById(id).orElse(null);
    } 
}