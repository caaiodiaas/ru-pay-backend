package rupay.api.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.EmpresaModelo;
import rupay.api.repositorio.EmpresaRepositorio;

@Service
public class EmpresaServico {
    
    @Autowired
    private EmpresaRepositorio repo;

    @Autowired
    private RespostaModelo resp;


    //Cadastrar e Editar Empresas
    public ResponseEntity<?> cadastrarAlterar(EmpresaModelo model,String acao){     
                return new ResponseEntity<EmpresaModelo>(repo.save(model),HttpStatus.OK);
    }

    //Listar Empresas
    public Iterable<EmpresaModelo> listar(){
        return repo.findAll();
    }

    //Remover Empresas
    public ResponseEntity<RespostaModelo> remover(long id){
        repo.deleteById(id);
        resp.setMensagem("Produto Removido");
        return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
    }    
}
