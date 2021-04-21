package io.apibr.cep.adapters.controller;

import io.apibr.cep.adapters.api.EnderecoResponse;
import io.apibr.cep.core.domain.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/busca-cep")
public class BuscaCEPController {

    Endereco endereco;

    @GetMapping("/v1/consulta-cep/{cep}")
    public EnderecoResponse buscaCep(@Valid @PathVariable("cep") String cep) {

        return EnderecoResponse.converteEnderecoDataToResponse(endereco.buscaEnderecoPeloCep(cep));

    }

    @GetMapping("/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}")
    public List<EnderecoResponse> buscaCepComEnderecoECidade(@Valid @PathVariable("endereco") String enderecoCliente,
                                             @PathVariable("cidade") String cidade){

        List<Endereco> listaEnderecos = endereco.buscaCepPeloEndereco(enderecoCliente, cidade);
        List<EnderecoResponse> enderecoResponse = new ArrayList<>();
        for (Endereco enderecoRetorno : listaEnderecos) {
            enderecoResponse.add(EnderecoResponse.converteEnderecoDataToResponse(enderecoRetorno));
        }

        return enderecoResponse;

    }

}
