package rupay.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteModelo extends Usuario{

    private String nome;
    private String matricula;
    //@OneToOne(mappedBy = "cliente")
    //private CarteiraModelo carteira;

}
