package app.portfolio.service;

import app.portfolio.model.Educacion;
import app.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    private EducacionRepository eduRepo;

    @Override
    public List<Educacion> getEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        eduRepo.save(educacion);
    }

    @Override
    public void deleteEducacion(int id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(int id) {
        return eduRepo.findById(id).orElse(null);
    }
    
}
