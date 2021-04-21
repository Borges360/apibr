package io.apibr.cep.adapters.repository;

import io.apibr.cep.adapters.data.CidadeData;
import io.apibr.cep.adapters.data.EnderecoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRespository extends JpaRepository<EnderecoData, String> {

    Optional<EnderecoData> findById(String cep);

    @Query("select u from EnderecoData u inner join u.idCidade ar where ar.cidade = :cidade and u.logradouro like %:logradouro%")
    List<EnderecoData>  findByidCidadeInAndAndLogradouro(String cidade, String logradouro);
}
