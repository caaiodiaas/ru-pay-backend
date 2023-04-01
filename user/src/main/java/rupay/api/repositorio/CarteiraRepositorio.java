package rupay.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rupay.api.modelo.CarteiraModelo;

@Repository
public interface CarteiraRepositorio extends CrudRepository<CarteiraModelo, Long>{
    
}
