package br.com.bancodigital.mscliente.adapter.in.web.controller;

import br.com.bancodigital.mscliente.domain.model.exception.MsClienteException;
import br.com.bancodigital.mscliente.domain.model.exception.errorcode.EstruturaErroCliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public String check() {
        return "MS-Cliente is UP and Running!";
    }

    // Endpoint específico para validar o Critério de Aceite: "Erro padronizado em falha simulada"
    @GetMapping("/test-error")
    public void simulateError() {
        throw new MsClienteException(EstruturaErroCliente.ERRO_INESPERADO);
    }
}