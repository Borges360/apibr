package io.apibr.cep;

import io.apibr.cep.adapters.controller.BuscaCEPController;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import io.apibr.cep.utils.EntityUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MockitoTest {

    @Spy
    @InjectMocks
    BuscaCEPController buscaCEPController;

    @Mock
    EnderecoRespository enderecoRespository;

    @DisplayName("Valida Busca Cep")
    @Test
    void validate_busca_success() {

        //Mockito.when(enderecoRespository.findByCep(ArgumentMatchers.any())).thenReturn(EntityUtils.criarEndereco());
        //Assertions.assertEquals();
    }

}
