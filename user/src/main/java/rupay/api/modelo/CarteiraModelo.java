package rupay.api.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @OneToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private ClienteModelo cliente;

    @OneToMany(mappedBy = "carteira")
    @JsonManagedReference
    private List<TransacaoModelo> transacoes = new ArrayList<TransacaoModelo>();

}
