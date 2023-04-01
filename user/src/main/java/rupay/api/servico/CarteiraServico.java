package rupay.api.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.CarteiraModelo;
import rupay.api.repositorio.CarteiraRepositorio;

@Service
public class CarteiraServico {
    
    @Autowired
    private CarteiraRepositorio repo;

    @Autowired
    private RespostaModelo resp;


    //Cadastrar e Editar Carteiras
    public ResponseEntity<?> cadastrarAlterar(CarteiraModelo model,String acao){     
                return new ResponseEntity<CarteiraModelo>(repo.save(model),HttpStatus.OK);
    }

    //Listar Carteiras
    public Iterable<CarteiraModelo> listar(){
        return repo.findAll();
    }

    //Remover Carteiras
    public ResponseEntity<RespostaModelo> remover(long id){
        repo.deleteById(id);
        resp.setMensagem("Produto Removido");
        return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
    }    
}
