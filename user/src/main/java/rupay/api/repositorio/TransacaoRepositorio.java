package rupay.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rupay.api.modelo.TransacaoModelo;

@Repository
public interface TransacaoRepositorio extends CrudRepository<TransacaoModelo, Long>{
    
}
