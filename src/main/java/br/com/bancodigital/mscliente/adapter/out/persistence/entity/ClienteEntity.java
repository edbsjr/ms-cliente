package br.com.bancodigital.mscliente.adapter.out.persistence.entity;

import br.com.bancodigital.mscliente.domain.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    private  UUID id;

    @Column(name = "account_id", nullable = false, unique = true)
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

}