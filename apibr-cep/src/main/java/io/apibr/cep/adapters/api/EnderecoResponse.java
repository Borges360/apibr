package io.apibr.cep.adapters.api;

import io.apibr.cep.adapters.data.EnderecoData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EnderecoResponse extends JdkSerializationRedisSerializer implements Serializable {

    private String cep;
    private String logradouro;
    private String tipoLogradouro;
    private String complemento;
    private String local;
    private String cidade;
    private String estado;


    private EnderecoResponse(EnderecoData enderecoData) {

        this.cep = enderecoData.getCep();
        this.logradouro = enderecoData.getLogradouro();
        this.tipoLogradouro = enderecoData.getTipoLogradouro();
        this.complemento = enderecoData.getComplemento();
        this.local = enderecoData.getLocal();
        this.cidade = enderecoData.getIdCidade().getCidade();
        this.estado = enderecoData.getIdCidade().getUf();

    }

    public static EnderecoResponse converteEnderecoDataToResponse(EnderecoData endereco){
        return new EnderecoResponse(endereco);
    }
}
