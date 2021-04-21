package io.apibr.cep.adapters.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cepbr_endereco")
public class EnderecoData {

    @Id
    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "local")
    private String local;

    @JoinColumn(name = "id_cidade")
    @ManyToOne
    private CidadeData idCidade;

    @Column(name = "id_bairro")
    private String idBairro;

}
