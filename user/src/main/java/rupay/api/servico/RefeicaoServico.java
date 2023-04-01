package rupay.api.servico;

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

    public Iterable<RefeicaoModelo> listar(){
        return repo.findAll();
    }

    // cadastrar ou alterar refeicao
    public ResponseEntity<?> cadastrarAlterar(RefeicaoModelo modelo, String acao){

        if (Float.toString(modelo.getValor()) == "") {
            resp.setMensagem("O valor da refeição é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else if (modelo.getData().equals("")){
            resp.setMensagem("A data da refeição é obrigatória!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else if(modelo.getTipoRefeicao().equals("")){
            resp.setMensagem("O tipo da refeição é obrigatório!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else if(modelo.getDescricao().equals("")){
            resp.setMensagem("A descrição da refeição é obrigatória!");
            return new ResponseEntity<RespostaModelo>(resp, HttpStatus.BAD_REQUEST);
        }else{
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<RefeicaoModelo>(repo.save(modelo), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<RefeicaoModelo>(repo.save(modelo), HttpStatus.OK);
            }
        }
    }

    // remover refeicao
    public ResponseEntity<RespostaModelo> remover(Long id){
        repo.deleteById(id);
        resp.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(resp, HttpStatus.OK);
    }
    
}
