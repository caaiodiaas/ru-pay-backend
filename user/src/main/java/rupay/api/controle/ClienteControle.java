package rupay.api.controle;

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
import rupay.api.modelo.ClienteModelo;
import rupay.api.servico.ClienteServico;


@RestController
public class ClienteControle {
    
    @Autowired
    private ClienteServico serv;

    @DeleteMapping("/cliente/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return serv.remover(id);
    }

    @PutMapping("/cliente/alterar")
    public ResponseEntity<?> alterar(@RequestBody ClienteModelo model){
        return serv.cadastrarAlterar(model,"alterar");
    }

    @PostMapping("/cliente/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteModelo model){
        return serv.cadastrarAlterar(model,"cadastrar");
    }

    @GetMapping("/cliente/listar")
    public Iterable<ClienteModelo> listar(){
        return serv.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "Api cliente rodou";
    }
}
