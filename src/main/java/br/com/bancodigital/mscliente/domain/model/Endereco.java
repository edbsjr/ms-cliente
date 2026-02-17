package br.com.bancodigital.mscliente.domain.model;

import br.com.bancodigital.mscliente.domain.model.enums.UnidadeFederativa;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@ToString
public class Endereco{
    private String logradouro;
    private String cidade;
    private UnidadeFederativa uf;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
}
