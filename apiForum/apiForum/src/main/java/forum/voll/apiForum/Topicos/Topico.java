package forum.voll.apiForum.Topicos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Topico")
@Entity(name = "topicos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String curso;
    private String mensagem;
    private String titulo;

    public Topico(DadosCadastroTopicos dados) {
           this.curso = dados.curso();
           this.mensagem = dados.mensagem();
           this.titulo = dados.titulo();

    }



}
