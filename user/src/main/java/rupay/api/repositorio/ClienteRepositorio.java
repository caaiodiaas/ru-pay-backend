package rupay.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rupay.api.modelo.ClienteModelo;

@Repository
public interface ClienteRepositorio  extends CrudRepository<ClienteModelo,Long>{
    
}
