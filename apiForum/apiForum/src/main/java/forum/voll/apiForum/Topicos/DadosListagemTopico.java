package forum.voll.apiForum.Topicos;

public record DadosListagemTopico(String mensagem, String curso, String titulo) {
    public DadosListagemTopico(Object topico){
        this(topico.getMensagem(), topico.getCurso(), topico.getTitulo());
    }
}
