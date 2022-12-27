package app.portfolio.service;

import app.portfolio.model.Proyecto;
import app.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private ProyectoRepository repo;

    @Override
    public List<Proyecto> getProyectos() {
        return repo.findAll();
    }

    @Override
    public void saveProyecto(Proyecto pro) {
        repo.save(pro);
    }

    @Override
    public void deleteProyecto(int id) {
        repo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(int id) {
        return repo.findById(id).orElse(null);
    }
}
