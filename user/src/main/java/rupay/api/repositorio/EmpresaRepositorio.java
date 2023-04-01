package rupay.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rupay.api.modelo.EmpresaModelo;

@Repository
public interface EmpresaRepositorio extends CrudRepository<EmpresaModelo, Long>{
    
}
