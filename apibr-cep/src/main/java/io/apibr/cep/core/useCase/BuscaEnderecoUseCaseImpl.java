package io.apibr.cep.core.useCase;

import io.apibr.cep.adapters.api.EnderecoResponse;
import io.apibr.cep.adapters.data.EnderecoData;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscaEnderecoUseCaseImpl {

    private final EnderecoRespository enderecoRespository;

    public BuscaEnderecoUseCaseImpl(EnderecoRespository enderecoRespository) {
        this.enderecoRespository = enderecoRespository;
    }

    @Cacheable(cacheNames = "endereco", key="#root.method.name")
    public List<EnderecoResponse> execute(String cidade, String enderecoCliente) {
        List<EnderecoResponse> listaEnderecos = new ArrayList<>();
        enderecoRespository.findByidCidadeInAndLogradouro(cidade, enderecoCliente)
                .forEach(enderecoData -> listaEnderecos.add(EnderecoResponse.converteEnderecoDataToResponse(enderecoData)));
        return listaEnderecos;
    }
}
