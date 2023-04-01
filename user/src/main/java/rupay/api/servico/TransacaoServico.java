package rupay.api.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.TransacaoModelo;
import rupay.api.repositorio.TransacaoRepositorio;

@Service
public class TransacaoServico {
    
    @Autowired
    private TransacaoRepositorio repo;

    @Autowired
    private RespostaModelo resp;


    //Cadastrar e Editar Transacaos
    public ResponseEntity<?> cadastrarAlterar(TransacaoModelo model,String acao){     
                return new ResponseEntity<TransacaoModelo>(repo.save(model),HttpStatus.OK);
    }

    //Listar Transacaos
    public Iterable<TransacaoModelo> listar(){
        return repo.findAll();
    }

    //Remover Transacaos
    public ResponseEntity<RespostaModelo> remover(long id){
        repo.deleteById(id);
        resp.setMensagem("Produto Removido");
        return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
    }    
}
