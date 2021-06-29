package io.apibr.financas.adapters.http;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/initializer")
@Api(tags = "/initializer", value = "Api para inicializar o módulo financeiro")
public class InitializerController {

    @ApiResponses(value = {@ApiResponse(code = 202, message = "Requisição recebida. Processando dados da B3"),
            @ApiResponse(code = 500, message = "Erro 500")})
    @GetMapping(value = "/v1/initializer")
    public ResponseEntity<?> inicializar() {
        log.info("Requisição recebida, inicializando download da série histórica da B3");

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}
