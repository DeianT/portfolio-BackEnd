package app.portfolio.service;

import app.portfolio.model.Experiencia;
import app.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private ExperienciaRepository repo;

    @Override
    public List<Experiencia> getExperiencia() {
        return repo.findAll();
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        repo.save(exp);
    }

    @Override
    public void deleteExperiencia(int id) {
        repo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(int id) {
        return repo.findById(id).orElse(null);
    }
}
