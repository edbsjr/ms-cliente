package br.com.bancodigital.mscliente.adapter.out.persistence.entity;

import br.com.bancodigital.mscliente.domain.model.enums.UnidadeFederativa;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class EnderecoEmbeddable {
    @Column
    private String logradouro;
    @Column
    private String cidade;
    @Column
    private UnidadeFederativa uf;
    @Column
    private Integer numero;
    @Column
    private String complemento;
    @Column
    private String cep;
    @Column
    private String bairro;
}
