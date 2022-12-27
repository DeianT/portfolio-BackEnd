package app.portfolio.repository;

import app.portfolio.model.Educacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
    
}
