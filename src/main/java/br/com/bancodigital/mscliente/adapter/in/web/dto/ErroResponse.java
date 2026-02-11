package br.com.bancodigital.mscliente.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErroResponse {

    private final String codigo;
    private final String mensagem;
    private final int httpStatus;
    private final LocalDateTime timestamp;
    private final List<ValidacaoErros> listaErros; //para acumular mais erros

    public record ValidacaoErros(String field, String mensagem){}
}
