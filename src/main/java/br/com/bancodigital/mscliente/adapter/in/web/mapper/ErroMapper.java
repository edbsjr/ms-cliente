package br.com.bancodigital.mscliente.adapter.in.web.mapper;

import br.com.bancodigital.mscliente.adapter.in.web.dto.ErroResponse;
import br.com.bancodigital.mscliente.domain.model.exception.errorcode.EstruturaErroCliente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErroMapper {

    public static ErroResponse deEstruturaErro(EstruturaErroCliente estrutura){
        return ErroResponse.builder().
                codigo(estrutura.getCodigo()).
                mensagem(estrutura.getMensagem()).
                httpStatus(estrutura.getHttpStatus().value()).
                timestamp(LocalDateTime.now())
                .build();
    }

    public static ErroResponse deEstruturaErro(EstruturaErroCliente estrutura, List<ErroResponse.ValidacaoErros> listaErros){
        return ErroResponse.builder().
                codigo(estrutura.getCodigo()).
                mensagem(estrutura.getMensagem()).
                httpStatus(estrutura.getHttpStatus().value()).
                timestamp(LocalDateTime.now()).
                listaErros(listaErros)
                .build();
    }
}
