package rupay.api.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carteira")
@Getter
@Setter
public class CarteiraModelo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private float saldo;

    @OneToMany(mappedBy = "carteira")
    private List<TransacaoModelo> transacao = new ArrayList<TransacaoModelo>();

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private ClienteModelo cliente;

}
