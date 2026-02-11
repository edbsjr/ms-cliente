package br.com.bancodigital.mscliente.domain.model;

import br.com.bancodigital.mscliente.adapter.out.persistence.entity.EnderecoEmbeddable;
import br.com.bancodigital.mscliente.domain.model.enums.Status;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente {


    private final UUID id;

    private final UUID accountId;

    private String nome;

    private String email;

    private String documento;

    private Status status;

    private Endereco endereco;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    // Construtor para novos cadastros (Regra de Negócio)
    public Cliente(UUID accountId, String nome, String email, String documento) {
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.status = Status.PENDENTE_DADOS;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    // Métodos de Comportamento
    public void alterarStatus(Status novoStatus) {
        this.status = novoStatus;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void atualizarEndereco(Endereco novoEndereco) {
        this.endereco = novoEndereco;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void atualizarDados(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.dataAtualizacao = LocalDateTime.now();
    }
}
