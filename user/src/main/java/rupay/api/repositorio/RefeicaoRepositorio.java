package rupay.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rupay.api.modelo.RefeicaoModelo;

@Repository
public interface RefeicaoRepositorio extends CrudRepository<RefeicaoModelo, Long>{
    
}
