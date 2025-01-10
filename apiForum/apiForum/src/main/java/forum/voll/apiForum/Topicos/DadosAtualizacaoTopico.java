package forum.voll.apiForum.Topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String mensagem,
        String curso,
        String titulo) {
}
