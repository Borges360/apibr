package io.apibr.cep.utils;

import io.apibr.cep.adapters.api.EnderecoResponse;
import io.apibr.cep.adapters.data.CidadeData;
import io.apibr.cep.adapters.data.EnderecoData;

public class EntityUtils {

    public static EnderecoData criarEndereco() {
        return EnderecoData.builder()
                .cep("04561914")
                .logradouro("Rua Guararapes 443")
                .tipoLogradouro("")
                .complemento("")
                .local("Edifício e Condomínio Brooklin New Life")
                .idCidade(criaCidade())
                .idBairro("25254")
                .build();
    }

    private static CidadeData criaCidade() {
        return CidadeData.builder()
                .idCidade(9668)
                .uf("SP")
                .cidade("São Paulo")
                .codIbge("3550308")
                .area(1521.11)
                .build();
    }
}
