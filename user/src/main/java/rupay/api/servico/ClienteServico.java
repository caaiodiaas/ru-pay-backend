package rupay.api.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.ClienteModelo;
import rupay.api.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
    
    @Autowired
    private ClienteRepositorio repo;

    @Autowired
    private RespostaModelo resp;


    //Cadastrar e Editar Clientes
    public ResponseEntity<?> cadastrarAlterar(ClienteModelo model,String acao){
        if(model.getLogin().equals("")){
            resp.setMensagem("O login é obrigatório");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getSenha().equals("")){
            resp.setMensagem("A senha é obrigatória");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ClienteModelo>(repo.save(model),HttpStatus.CREATED);
            } else{
                return new ResponseEntity<ClienteModelo>(repo.save(model),HttpStatus.OK);
            }

        }
    }

    //Listar Clientes
    public Iterable<ClienteModelo> listar(){
        return repo.findAll();
    }

    //Remover Clientes
    public ResponseEntity<RespostaModelo> remover(long id){
        repo.deleteById(id);
        resp.setMensagem("Produto Removido");
        return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
    }    
}
