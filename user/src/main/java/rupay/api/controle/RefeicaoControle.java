package rupay.api.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rupay.api.modelo.RefeicaoModelo;
import rupay.api.modelo.RespostaModelo;
import rupay.api.servico.RefeicaoServico;

@RestController
@CrossOrigin("*")
public class RefeicaoControle {

    @Autowired
    private RefeicaoServico serv;

    @DeleteMapping("/refeicao/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return serv.remover(id);
    }

    @PutMapping("/refeicao/alterar")
    public ResponseEntity<?> alterar(@RequestBody RefeicaoModelo model){
        return serv.cadastrarAlterar(model, "alterar");
    }

    @PostMapping("/refeicao/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody RefeicaoModelo model){
        return serv.cadastrarAlterar(model, "cadastrar");
    }

    @GetMapping("/refeicao/listar")
    public Iterable<RefeicaoModelo> listar(){
        return serv.listar();
    }

    @GetMapping("/refeicao/buscar/{id}")
    public Optional<RefeicaoModelo> buscar(@PathVariable long id){
        return serv.buscar(id);
    }

}
