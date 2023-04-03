package rupay.api.servico;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.TransacaoModelo;
import rupay.api.repositorio.CarteiraRepositorio;
import rupay.api.repositorio.TransacaoRepositorio;

@Service
public class TransacaoServico {
    
    @Autowired
    private TransacaoRepositorio repo;

    @Autowired
    private CarteiraRepositorio repoCarteira;

    @Autowired
    private RespostaModelo resp;


    //Cadastrar e Editar Transacoes
    public ResponseEntity<?> cadastrarAlterar(TransacaoModelo model,String acao){  
        
        if(acao.equals("cadastrar")){
            if(model.getCarteira() == null){
                resp.setMensagem("A carteira deve ser informada");
                return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
            }else if(model.getData() == null){
                resp.setMensagem("A data é obrigatória");
                return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
            }else if(model.getValor() == 0){
                resp.setMensagem("O valor é obrigatório");
                return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
            }else{
                if (!(repoCarteira.findById(model.getCarteira().getId()).isPresent())) {
                    resp.setMensagem("Carteira não encontrada!");
                    return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
                }else{
                    return new ResponseEntity<TransacaoModelo>(repo.save(model),HttpStatus.CREATED);
                }
            }
        }else{
            if (repo.findById(model.getId()).isPresent()) {
                return new ResponseEntity<TransacaoModelo>(repo.save(model),HttpStatus.OK);
            }else{
                resp.setMensagem("Carteira não encontrada!");
                return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
            }
        }  
        
    }

    //Listar Transacoes
    public Iterable<TransacaoModelo> listar(){
        return repo.findAll();
    }

    //Buscar Transacoes
    public Optional<TransacaoModelo> buscar(long id){
        return repo.findById(id);
    }

    //Remover Transacoes
    public ResponseEntity<RespostaModelo> remover(long id){

        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            resp.setMensagem("A transação foi removida com sucesso!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
        }else{
            resp.setMensagem("Transação não encontrada!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }
    }    
}
