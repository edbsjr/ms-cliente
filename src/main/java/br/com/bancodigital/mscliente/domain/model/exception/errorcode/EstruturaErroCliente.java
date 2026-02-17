package br.com.bancodigital.mscliente.domain.model.exception.errorcode;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum EstruturaErroCliente {
    // Codigo de erros com HTTP 400 Requisição inválida
    DADOS_INVALIDOS("CLNT-001", "Os dados informados são inválidos ou estão mal formatados", HttpStatus.BAD_REQUEST),

    // Codigo de erros com HTTP 409 Conflito
    DOCUMENTO_JA_EXISTE("CLNT-031", "Já existe um usuário com esse documento.", HttpStatus.CONFLICT),

    ERRO_INESPERADO("CLNT-999", "Ocorreu um erro inesperado no sistema", HttpStatus.INTERNAL_SERVER_ERROR);


    private final String codigo;
    private final String mensagem;
    private final HttpStatus httpStatus;

    EstruturaErroCliente(String codigo, String mensagem, HttpStatus httpStatus){
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
    }

}
