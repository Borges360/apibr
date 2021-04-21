package io.apibr.cep.adapters.api;

import io.apibr.cep.core.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoResponse {

    private String cep;
    private String logradouro;
    private String tipoLogradouro;
    private String complemento;
    private String local;
    private String cidade;
    private String estado;

    public static EnderecoResponse converteEnderecoDataToResponse(Endereco enderecoData) {

        return new EnderecoResponse.EnderecoResponseBuilder()
                .cep(enderecoData.getCep())
                .cidade(enderecoData.getCidade())
                .local(enderecoData.getLocal())
                .logradouro(enderecoData.getLogradouro())
                .tipoLogradouro(enderecoData.getTipoLogradouro())
                .complemento(enderecoData.getComplemento())
                .build();

    }


}
