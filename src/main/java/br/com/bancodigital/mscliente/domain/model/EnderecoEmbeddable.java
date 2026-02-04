package br.com.bancodigital.mscliente.domain.model;

import br.com.bancodigital.mscliente.domain.model.enums.UnidadeFederativa;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@ToString
@Embeddable
public class EnderecoEmbeddable {
    private String logradouro;
    private String cidade;
    private UnidadeFederativa uf;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
}
