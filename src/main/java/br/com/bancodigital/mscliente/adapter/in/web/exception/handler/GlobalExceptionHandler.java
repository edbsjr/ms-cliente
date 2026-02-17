package br.com.bancodigital.mscliente.adapter.in.web.exception.handler;

import br.com.bancodigital.mscliente.adapter.in.web.dto.ErroResponse;
import br.com.bancodigital.mscliente.adapter.in.web.mapper.ErroMapper;
import br.com.bancodigital.mscliente.domain.model.exception.MsClienteException;
import br.com.bancodigital.mscliente.domain.model.exception.errorcode.EstruturaErroCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(MsClienteException.class)
    public ResponseEntity<ErroResponse> handleMsClienteException(MsClienteException ex) {
        log.warn("Erro de negócio capturado : {} - {}",ex.getEstrutura().getCodigo(), ex.getMessage());

        HttpStatus status = ex.getEstrutura().getHttpStatus();

        ErroResponse erroResponse = ErroMapper.deEstruturaErro(ex.getEstrutura());
        return new ResponseEntity<>(erroResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleGenericException(Exception ex){
        log.warn("Erro inesperado no sistema", ex);

        EstruturaErroCliente erro = EstruturaErroCliente.ERRO_INESPERADO;

        ErroResponse erroResponse = ErroMapper.deEstruturaErro(erro);//

        return new ResponseEntity<>(erroResponse,erro.getHttpStatus());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        log.warn("Erro de campos invalidos ou nulos. {} - {}", ex.getMessage(), ex.getBindingResult().getFieldErrors());

        EstruturaErroCliente erro = EstruturaErroCliente.DADOS_INVALIDOS;

        List<ErroResponse.ValidacaoErros> errosLista = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> new ErroResponse.ValidacaoErros(f.getField(), f.getDefaultMessage()))
                .toList();

        ErroResponse response = ErroMapper.deEstruturaErro(erro, errosLista);

        return ResponseEntity.badRequest().body(response);
    }

}
