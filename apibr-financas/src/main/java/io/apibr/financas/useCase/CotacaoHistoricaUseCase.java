package io.apibr.financas.useCase;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CotacaoHistoricaUseCase {

    public void execute() {

    }

    private List<Integer> listaDezAnos() {
        List<Integer> listaAnos = new ArrayList<>();
        LocalDateTime lt = LocalDateTime.now();
        for(int i = 0; i<=10; i++) {
            listaAnos.add(lt.getYear()-i);
        }
        return listaAnos;
    }


}
