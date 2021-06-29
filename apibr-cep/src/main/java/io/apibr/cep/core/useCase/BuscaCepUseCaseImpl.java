package io.apibr.cep.core.useCase;

import io.apibr.cep.adapters.api.EnderecoResponse;
import io.apibr.cep.adapters.data.EnderecoData;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BuscaCepUseCaseImpl {

    private final EnderecoRespository enderecoRespository;


    public BuscaCepUseCaseImpl(EnderecoRespository enderecoRespository) {
        this.enderecoRespository = enderecoRespository;
    }

    @Cacheable(cacheNames = "cep", key="#root.method.name")
    public EnderecoResponse excute(String cep) {
        return EnderecoResponse.converteEnderecoDataToResponse(enderecoRespository.findByCep(cep));
    }

}
