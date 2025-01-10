package forum.voll.apiForum.controller;

import forum.voll.apiForum.Topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;
    private DadosCadastroTopicos dados;

    @PostMapping
    @Transactional

    public void cadastrar(@RequestBody @Valid DadosCadastroTopicos dados) { repository.save(new Topico(dados));}
//    public ResponseEntity<Topico> cadastrar(@RequestBody @Valid DadosCadastroTopicos dados) {
//        //System.out.println("Dados recebidos: " + dados);
//        Topico topico = new Topico(dados);
//        //System.out.println("Topico criado: " + topico);
//        try {
//            repository.save(topico);
//        } catch (Exception e) {
//            //System.out.println("Erro ao salvar o tópico: " + e.getMessage());
//            throw e;
//}
//        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
//    }


 @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

@PutMapping
@Transactional
public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
     var topico = repository.getReferenceById(dados.id());
     topico.atualizarInformacoes(dados);

}

 @PutMapping
 @Transactional
 public void excluir(@PathVariable Long id){
     var topico = repository.getReferenceById(id);
     topico.excluir();
 }


}
