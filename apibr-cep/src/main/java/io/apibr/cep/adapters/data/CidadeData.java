package io.apibr.cep.adapters.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="cidade")
public class CidadeData {

    @Id
    @Column(name = "ID_CIDADE")
    private Integer idCidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "COD_IBGE")
    private String codIbge;

    @Column(name = "AREA")
    private Double area;

}
