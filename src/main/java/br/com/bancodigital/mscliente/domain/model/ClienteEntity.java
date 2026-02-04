package br.com.bancodigital.mscliente.domain.model;

import br.com.bancodigital.mscliente.domain.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;

        import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @EqualsAndHashCode.Include
    @Id
    private  UUID id;

    @Column(name = "account_id", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID accountId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String documento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Embedded
    private EnderecoEmbeddable endereco;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    // Construtor para novos cadastros (Regra de Negócio)
    public ClienteEntity(UUID accountId, String nome, String email, String documento) {
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

    public void atualizarEndereco(EnderecoEmbeddable novoEndereco) {
        this.endereco = novoEndereco;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void atualizarDados(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.dataAtualizacao = LocalDateTime.now();
    }
}