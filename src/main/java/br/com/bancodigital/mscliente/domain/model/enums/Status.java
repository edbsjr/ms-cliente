package br.com.bancodigital.mscliente.domain.model.enums;

import lombok.Getter;

@Getter
public enum Status {
    PENDENTE_DADOS("Dados Pendentes"),
    ATIVO("Ativo"),
    CANCELADO("Cancelado"),
    BLOQUEADO("Bloqueado");

    private final String description;
    Status(String description) { this.description = description; }
}