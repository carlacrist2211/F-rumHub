package forum.voll.apiForum.Topicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroTopicos(

        @NotBlank
        @Size(min = 10, max = 100)
        String mensagem,

        @NotNull
        String curso,

        @NotBlank
        String titulo){


        public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        }


        public void excluir() {
        }
}
