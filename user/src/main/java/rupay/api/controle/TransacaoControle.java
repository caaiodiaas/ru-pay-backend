package rupay.api.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rupay.api.modelo.RespostaModelo;
import rupay.api.modelo.TransacaoModelo;
import rupay.api.servico.TransacaoServico;


@RestController
public class TransacaoControle {
    
    @Autowired
    private TransacaoServico serv;

    @DeleteMapping("/transacao/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return serv.remover(id);
    }

    @PutMapping("/transacao/alterar")
    public ResponseEntity<?> alterar(@RequestBody TransacaoModelo model){
        return serv.cadastrarAlterar(model,"alterar");
    }

    @PostMapping("/transacao/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody TransacaoModelo model){
        return serv.cadastrarAlterar(model,"cadastrar");
    }

    @GetMapping("/transacao/listar")
    public Iterable<TransacaoModelo> listar(){
        return serv.listar();
    }

    @GetMapping("/transacao/buscar/{id}")
    public Optional<TransacaoModelo> buscar(@PathVariable long id){
        return serv.buscar(id);
    }
}
