/**
package io.apibr.cep.adapters.controller;

import io.apibr.cep.core.domain.Endereco;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
public class BuscaCEPControllerTest {

    private BuscaCEPController buscaCEPController;

    @Mock
    private Endereco endereco;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        buscaCEPController = new BuscaCEPController(endereco);
    }

    @Test
    public void retorna_Endereco_A_Partir_do_Cep() {

        // Class<EnderecoRespository> enderecoCompleto ;
        // Mockito.when(EnderecoRespository.class).thenReturn(enderecoCompleto);

        // buscaCEPController.buscaCep("04561914");

    }

    @Test
    public void testBuscaCepComEnderecoECidade() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}", "value", "value");
        MockMvcBuilders.standaloneSetup(this.buscaCEPController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testBuscaCepComEnderecoECidade2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}", "value", "value");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.buscaCEPController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testBuscaCepComEnderecoECidade3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}", "value", "value");
        MockMvcBuilders.standaloneSetup(this.buscaCEPController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testBuscaCepComEnderecoECidade4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}", "value", "value");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.buscaCEPController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }


}
 **/
