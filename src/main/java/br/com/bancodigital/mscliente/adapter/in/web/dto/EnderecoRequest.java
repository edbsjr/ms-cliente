package br.com.bancodigital.mscliente.adapter.in.web.dto;

import br.com.bancodigital.mscliente.adapter.in.web.dto.validation.Cep;
import br.com.bancodigital.mscliente.domain.model.enums.UnidadeFederativa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequest(
        @NotBlank (message = "Logradouro é um campo obrigatório")
        String logradouro,
        @NotBlank(message = "Cidade é um campo obrigatório")
        String cidade,
        @NotNull(message = "Estado(UF) é um campo obrigatório")
        UnidadeFederativa uf,
        Integer numero,
        String complemento,
        @Cep
        String cep,
        String bairro
) {

}
