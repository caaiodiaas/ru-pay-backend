package rupay.api.servico;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.CarteiraModelo;
import rupay.api.repositorio.CarteiraRepositorio;
import rupay.api.repositorio.ClienteRepositorio;

@Service
public class CarteiraServico {
    
    @Autowired
    private CarteiraRepositorio repo;

    @Autowired
    private ClienteRepositorio repoCliente;

    @Autowired
    private RespostaModelo resp;


    //Cadastrar e Editar Carteiras
    public ResponseEntity<?> cadastrarAlterar(CarteiraModelo model, String acao){   
        if(acao.equals("cadastrar")){
            if(model.getCliente() == null){
                    resp.setMensagem("O cliente deve ser informado");
                    return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
                }else if(repoCliente.findById(model.getCliente().getId()).get().getCarteira() != null){
                    resp.setMensagem("Esse cliente já possui uma carteira");
                    return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
                }            if (!(repoCliente.findById(model.getCliente().getId()).isPresent())) {
                    resp.setMensagem("Cliente não encontrado!");
                    return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
                }else{
                    return new ResponseEntity<CarteiraModelo>(repo.save(model),HttpStatus.CREATED);
                }
        }else{
            if (repo.findById(model.getId()).isPresent()) {
                return new ResponseEntity<CarteiraModelo>(repo.save(model),HttpStatus.OK);
            }else{
                resp.setMensagem("Carteira não encontrada!");
                return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
            }
        }  

    }

    //Listar Carteiras
    public Iterable<CarteiraModelo> listar(){
        return repo.findAll();
    }

    //Buscar Carteiras
    public Optional<CarteiraModelo> buscar(long id){
        return repo.findById(id);
    }

    //Remover Carteiras
    public ResponseEntity<RespostaModelo> remover(long id){
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            resp.setMensagem("A carteira foi removida com sucesso!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
        }else{
            resp.setMensagem("Carteira não encontrada!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }
    }    
}
