package io.apibr.cep.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cidade {

    private Integer idCidade;
    private String uf;
    private String cidade;

}
