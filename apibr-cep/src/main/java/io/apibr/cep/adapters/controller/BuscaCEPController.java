package io.apibr.cep.adapters.controller;

import io.apibr.cep.adapters.api.EnderecoResponse;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/busca-cep")
@Api(tags = "/busca-cep", value = "Grupo de API's para consulta de cep e endereço")
public class BuscaCEPController {

    private final EnderecoRespository enderecoRespository;

    public BuscaCEPController(EnderecoRespository enderecoRespository) {
        this.enderecoRespository = enderecoRespository;
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno OK com a transação encontrada."),
            @ApiResponse(code = 401, message = "Erro de autenticação dessa API"),
            @ApiResponse(code = 403, message = "Erro de autorização dessa API"),
            @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/v1/consulta-cep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnderecoResponse buscaCep(@Valid @PathVariable("cep") String cep) {
        return EnderecoResponse.converteEnderecoDataToResponse(enderecoRespository.findByCep(cep));
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno OK com a transação encontrada."),
            @ApiResponse(code = 401, message = "Erro de autenticação dessa API"),
            @ApiResponse(code = 403, message = "Erro de autorização dessa API"),
            @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnderecoResponse> buscaCepComEnderecoECidade(@Valid @PathVariable("endereco") String enderecoCliente,
                                             @PathVariable("cidade") String cidade){

        List<EnderecoResponse> listaEnderecos = new ArrayList<>();
        enderecoRespository.findByidCidadeInAndLogradouro(cidade, enderecoCliente)
                .forEach(enderecoData -> listaEnderecos.add(EnderecoResponse.converteEnderecoDataToResponse(enderecoData)));

        return listaEnderecos;

    }


}
