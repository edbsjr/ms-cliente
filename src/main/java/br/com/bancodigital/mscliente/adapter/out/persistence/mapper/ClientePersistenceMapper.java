package br.com.bancodigital.mscliente.adapter.out.persistence.mapper;

import br.com.bancodigital.mscliente.adapter.out.persistence.entity.ClienteEntity;
import br.com.bancodigital.mscliente.adapter.out.persistence.entity.EnderecoEmbeddable;
import br.com.bancodigital.mscliente.domain.model.Cliente;
import br.com.bancodigital.mscliente.domain.model.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {
    // Converte de Domínio para Entity
    ClienteEntity paraEntity(Cliente cliente);

    // Converte de Entity para Domínio
    Cliente paraDomain(ClienteEntity entity);

    // Mapper auxiliar para o Objeto de Valor (Endereco)
    EnderecoEmbeddable paraEmbeddable(Endereco endereco);

    Endereco paraDomain(EnderecoEmbeddable embeddable);

}
