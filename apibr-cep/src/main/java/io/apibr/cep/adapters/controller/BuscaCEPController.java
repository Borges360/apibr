package io.apibr.cep.adapters.controller;

import io.apibr.cep.adapters.api.EnderecoResponse;

import io.apibr.cep.adapters.data.EnderecoData;
import io.apibr.cep.adapters.exception.NotFoundException;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import io.apibr.cep.core.useCase.BuscaCepUseCaseImpl;
import io.apibr.cep.core.useCase.BuscaEnderecoUseCaseImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/busca-cep")
@Api(tags = "/busca-cep", value = "Grupo de API's para consulta de cep e endereço")
public class BuscaCEPController {

    private final BuscaCepUseCaseImpl buscaCepUseCase;

    private final BuscaEnderecoUseCaseImpl buscaEnderecoUseCase;

    public BuscaCEPController(BuscaCepUseCaseImpl buscaCepUseCase, BuscaEnderecoUseCaseImpl buscaEnderecoUseCase) {
        this.buscaCepUseCase = buscaCepUseCase;
        this.buscaEnderecoUseCase = buscaEnderecoUseCase;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno OK com a transação encontrada."),
            @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/v1/consulta-cep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaCep(@Valid @PathVariable("cep") String cep) {

        EnderecoResponse enderecoResponse = buscaCepUseCase.excute(cep);
        if(enderecoResponse == null)
            throw new NotFoundException("Endereço não encontrado");

        return new ResponseEntity<>(enderecoResponse, HttpStatus.OK);

    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno OK com a transação encontrada."),
            @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaCepComEnderecoECidade(@Valid @PathVariable("endereco") String enderecoCliente,
                                                                            @PathVariable("cidade") String cidade){

        List<EnderecoResponse> listaEnderecos = new ArrayList<>(buscaEnderecoUseCase.execute(cidade, enderecoCliente));

        if (listaEnderecos.size() == 0)
            throw new NotFoundException("Endereço não encontrado");

         return new ResponseEntity<>(listaEnderecos, HttpStatus.OK);

    }

}
