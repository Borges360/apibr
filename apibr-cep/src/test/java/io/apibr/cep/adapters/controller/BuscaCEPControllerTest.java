package io.apibr.cep.adapters.controller;

import io.apibr.cep.adapters.data.EnderecoData;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import io.apibr.cep.utils.EntityUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(BuscaCEPController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuscaCEPControllerTest {

    @InjectMocks
    BuscaCEPController buscaCEPController;

    @Mock
    EnderecoRespository enderecoRespository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        EnderecoData enderecoData = EntityUtils.criarEndereco();
        BDDMockito.when(enderecoRespository.findByCep(ArgumentMatchers.any()))
                .thenReturn(enderecoData);
    }

    @Test
    @DisplayName("Listar endereço com cep válido")
    public void listar_endereco_com_cep_valido() throws Exception {

        mockMvc.perform(get("/busca-cep/v1/consulta-cep/{cep}", "04561914"))
                .andExpect(status().isOk());
    }


}

