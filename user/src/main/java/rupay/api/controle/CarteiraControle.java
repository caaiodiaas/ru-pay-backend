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
import rupay.api.modelo.CarteiraModelo;
import rupay.api.servico.CarteiraServico;


@RestController
public class CarteiraControle {
    
    @Autowired
    private CarteiraServico serv;

    @DeleteMapping("/carteira/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return serv.remover(id);
    }

    @PutMapping("/carteira/alterar")
    public ResponseEntity<?> alterar(@RequestBody CarteiraModelo model){
        return serv.cadastrarAlterar(model,"alterar");
    }

    @PostMapping("/carteira/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody CarteiraModelo model){
        return serv.cadastrarAlterar(model,"cadastrar");
    }

    @GetMapping("/carteira/listar")
    public Iterable<CarteiraModelo> listar(){
        return serv.listar();
    }

}
