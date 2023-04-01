package rupay.api.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "refeicoes")
@Getter
@Setter
public class RefeicaoModelo {

    public enum TipoRefeicao  {
        ALMOCO, JANTAR;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoRefeicao tipoRefeicao;
    private String descricao;
    private float valor;
    private Date data;

}
