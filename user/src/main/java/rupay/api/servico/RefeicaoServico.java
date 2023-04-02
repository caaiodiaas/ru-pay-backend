package rupay.api.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rupay.api.modelo.RefeicaoModelo;
import rupay.api.modelo.RespostaModelo;
import rupay.api.repositorio.RefeicaoRepositorio;

@Service
public class RefeicaoServico {

    @Autowired
    private RefeicaoRepositorio repo;

    @Autowired
    private RespostaModelo resp;

    //Listar Refeições
    public Iterable<RefeicaoModelo> listar(){
        return repo.findAll();
    }

    //Buscar Refeições
    public Optional<RefeicaoModelo> buscar(long id){
        return repo.findById(id);
    }

    //Cadastrar e Editar Refeições
    public ResponseEntity<?> cadastrarAlterar(RefeicaoModelo model, String acao){

        if (model.getValor() == 0) {
            resp.setMensagem("O valor da refeição é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else if (model.getData() == null){
            resp.setMensagem("A data da refeição é obrigatória!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else if(model.getTipoRefeicao() == null){
            resp.setMensagem("O tipo da refeição é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else if(model.getDescricao().equals("") || model.getDescricao().equals("")){
            resp.setMensagem("A descrição da refeição é obrigatória!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else{
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<RefeicaoModelo>(repo.save(model), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<RefeicaoModelo>(repo.save(model), HttpStatus.OK);
            }
        }
    }

    // Remover Refeições
    public ResponseEntity<RespostaModelo> remover(Long id){

        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            resp.setMensagem("A refeição foi removida com sucesso!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.OK);
        }else{
            resp.setMensagem("Refeição não encontrada!");
            return new ResponseEntity<RespostaModelo>(resp,HttpStatus.BAD_REQUEST);
        }
    }
    
}
