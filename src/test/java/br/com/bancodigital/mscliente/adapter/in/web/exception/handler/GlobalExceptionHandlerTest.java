package br.com.bancodigital.mscliente.adapter.in.web.exception.handler;

import br.com.bancodigital.mscliente.domain.model.exception.MsClienteException;
import br.com.bancodigital.mscliente.domain.model.exception.errorcode.EstruturaErroCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUP(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TestController())
                .setControllerAdvice(globalExceptionHandler)
                .build();
    }

    @RestController
    static class TestController{

        @GetMapping("/teste/erro-generico")
        public void chamadaErroGenerico(){
            throw new RuntimeException();
        }

        @GetMapping("/teste/erro-documento-existente")
        public void chamadaErroDadosInvalidos(){
            throw new MsClienteException(EstruturaErroCliente.DOCUMENTO_JA_EXISTE);
        }

        @PostMapping("/teste/validacao")
        public void testarValidacao(@jakarta.validation.Valid @RequestBody RequestFake request) {
        }

        record RequestFake(@jakarta.validation.constraints.NotBlank String nome) {}
    }

    @Test
    @DisplayName("Deve retornar 500 INTERNAL SERVER ERROR para exceções genéricas")
    void deveRetornar500DeErroGenerico() throws Exception {
        mockMvc.perform(get("/teste/erro-generico"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.codigo").value("CLNT-999"))
                .andExpect(jsonPath("$.listaErros").doesNotExist())
                .andExpect(jsonPath("$.httpStatus").value(500));
    }

    @Test
    @DisplayName("Deve retornar 409 COMPLICT para DOCUMENTO_JA_EXISTE")
    void deveRetornar400DocumentoJaExiste() throws Exception {
        mockMvc.perform(get("/teste/erro-documento-existente"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.codigo").value("CLNT-031"))
                .andExpect(jsonPath("$.listaErros").doesNotExist())
                .andExpect(jsonPath("$.httpStatus").value(409));
    }

    @Test
    @DisplayName("Deve retornar 400 e LISTA de erros quando campo for inválido")
    void deveRetornar400ComLista() throws Exception {

        String jsonInvalido = "{\"nome\": \"\"}";

        mockMvc.perform(post("/teste/validacao")
                        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                        .content(jsonInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.codigo").value("CLNT-001"))
                .andExpect(jsonPath("$.httpStatus").value(400))
                .andExpect(jsonPath("$.listaErros").isArray())
                .andExpect(jsonPath("$.listaErros[0].field").value("nome"));
    }

}
