package br.com.bancodigital.mscliente.adapter.in.web.dto.mapper;

import br.com.bancodigital.mscliente.adapter.in.web.dto.ClienteRequest;
import br.com.bancodigital.mscliente.adapter.in.web.dto.EnderecoRequest;
import br.com.bancodigital.mscliente.domain.model.Cliente;
import br.com.bancodigital.mscliente.domain.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteWebMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountId", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "dataAtualizacao", ignore = true)
    Cliente paraDomain(ClienteRequest requestCliente);

    Endereco paraEndereco(EnderecoRequest requestEndereco);
}
