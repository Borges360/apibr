package io.apibr.cep.adapters.repository;

import io.apibr.cep.adapters.data.EnderecoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRespository extends JpaRepository<EnderecoData, String> {

    @Query("select  e from EnderecoData e where e.cep = :cep")
    EnderecoData findByCep(String cep);

    @Query("select u from EnderecoData u inner join u.idCidade ar where ar.cidade = :cidade and u.logradouro like %:logradouro%")
    List<EnderecoData> findByidCidadeInAndLogradouro(String cidade, String logradouro);
}
