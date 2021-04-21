package io.apibr.cep.core.domain;

import io.apibr.cep.adapters.data.EnderecoData;
import io.apibr.cep.adapters.repository.EnderecoRespository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Component
public class Endereco {

    EnderecoRespository enderecoRespository;

    private String cep;
    private String logradouro;
    private String tipoLogradouro;
    private String complemento;
    private String local;
    private String Cidade;
    private String idBairro;

    public Endereco buscaEnderecoPeloCep(String cep){

        Optional<EnderecoData> enderecoData = enderecoRespository.findById(cep);

        return new EnderecoBuilder()
                .cep(enderecoData.get().getCep())
                .logradouro(enderecoData.get().getLogradouro())
                .tipoLogradouro(enderecoData.get().getTipoLogradouro())
                .complemento(enderecoData.get().getComplemento())
                .local(enderecoData.get().getLocal())
                .Cidade(enderecoData.get().getIdCidade().getCidade())
                .idBairro(enderecoData.get().getIdBairro())
                .build();
    }

    public List<Endereco> buscaCepPeloEndereco(String endereco, String cidade) {
        List<EnderecoData> listaEnderecosData = enderecoRespository.findByidCidadeInAndAndLogradouro(cidade, endereco);
        List<Endereco> listaEnderecos = new ArrayList<>();
        for (EnderecoData enderecoData : listaEnderecosData) {
            for (Endereco enderecoLista: listaEnderecos) {
                enderecoLista.setCep(enderecoData.getCep());
                enderecoLista.setCidade(enderecoData.getIdCidade().getCidade());
                enderecoLista.setComplemento(enderecoData.getComplemento());
                enderecoLista.setLocal(enderecoData.getLocal());
                enderecoLista.setLogradouro(enderecoData.getLogradouro());
                enderecoLista.setTipoLogradouro(enderecoData.getTipoLogradouro());
                enderecoLista.setIdBairro(enderecoData.getIdBairro());

            }

        }
        return listaEnderecos;
    }

}
