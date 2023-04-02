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
import rupay.api.modelo.EmpresaModelo;
import rupay.api.servico.EmpresaServico;


@RestController
public class EmpresaControle {
    
    @Autowired
    private EmpresaServico serv;

    @DeleteMapping("/empresa/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return serv.remover(id);
    }

    @PutMapping("/empresa/alterar")
    public ResponseEntity<?> alterar(@RequestBody EmpresaModelo model){
        return serv.cadastrarAlterar(model,"alterar");
    }

    @PostMapping("/empresa/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody EmpresaModelo model){
        return serv.cadastrarAlterar(model,"cadastrar");
    }

    @GetMapping("/empresa/listar")
    public Iterable<EmpresaModelo> listar(){
        return serv.listar();
    }

    @GetMapping("/empresa/buscar/{id}")
    public Optional<EmpresaModelo> buscar(@PathVariable long id){
        return serv.buscar(id);
    }
}
