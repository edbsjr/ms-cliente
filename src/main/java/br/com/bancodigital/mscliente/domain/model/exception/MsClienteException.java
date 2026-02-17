package br.com.bancodigital.mscliente.domain.model.exception;

import br.com.bancodigital.mscliente.domain.model.exception.errorcode.EstruturaErroCliente;

public class MsClienteException extends RuntimeException {

    private final EstruturaErroCliente estruturaErroCliente;

    public MsClienteException(EstruturaErroCliente codigoErro) {
        super(codigoErro.getMensagem());
        this.estruturaErroCliente = codigoErro;
    }

    public EstruturaErroCliente getEstrutura()
    {return estruturaErroCliente;}

}
