package br.com.bancodigital.mscliente.adapter.in.web.dto;

import br.com.bancodigital.mscliente.domain.model.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


public record ClienteRequest (
    @NotBlank (message = "O nome é obrigatório")
    String nome,
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Esse email é inválido")
    String email,
    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "Esse CPF é inválido")
    String documento,
    @NotBlank(message = "Os dados de endereço são obrigatórios")
    @Valid
    Endereco endereco
){}
