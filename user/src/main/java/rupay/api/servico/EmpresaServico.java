package rupay.api.servico;


import java.util.Optional;

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
        if(model.getLogin() == null || model.getLogin().equals("")){
            resp.setMensagem("O login é obrigatório");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getSenha() == null || model.getSenha().equals("")){
            resp.setMensagem("A senha é obrigatória");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getEmail() == null || model.getEmail().equals("")){
            resp.setMensagem("O email é obrigatório");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getNomeResponsavel() == null || model.getNomeResponsavel().equals("")){
            resp.setMensagem("O nome do responsável é obrigatório");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getNomeEmpresa() == null || model.getNomeEmpresa().equals("")){
            resp.setMensagem("O nome da empresa é obrigatório");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getCnpj() == null || model.getCnpj().equals("")){
            resp.setMensagem("O CNPJ da empresa é obrigatório");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else if(model.getUniversidade() == null || model.getUniversidade().equals("")){
            resp.setMensagem("A universidade é obrigatória");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<EmpresaModelo>(repo.save(model),HttpStatus.CREATED);
            } else{
                return new ResponseEntity<EmpresaModelo>(repo.save(model),HttpStatus.OK);
            }
        }
    }

    //Listar Empresas
    public Iterable<EmpresaModelo> listar(){
        return repo.findAll();
    }

    //Buscar Empresas
    public Optional<EmpresaModelo> buscar(long id){
        return repo.findById(id);
    }

    //Remover Empresas
    public ResponseEntity<RespostaModelo> remover(long id){

        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            resp.setMensagem("A empresa foi removida com sucesso!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.OK);
        }else{
            resp.setMensagem("Empresa não encontrada!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }
    }    
}
