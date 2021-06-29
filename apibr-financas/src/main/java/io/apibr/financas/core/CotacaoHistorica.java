package io.apibr.financas.core;

import lombok.Data;

import java.util.Date;

@Data
public class CotacaoHistorica {

    private String tipoRegistro;
    private Date dataPregao;
    private String CodigoBDI;
    private String CodigoNegociacaoPapel;
    private String tipoMercado;
    private String nomeResumido;
    private String especificacaoPapel;
    private int prazoDiasMercadoTermo;
    private String moedaReferencia;
    private Double precoAbertura;
    private Double precoMaximo;
    private Double precoMinimo;
    private Double precoMedio;
    private Double precoUltimoNegocio;
    private Double precoMelhorOfertaCompra;
    private Double precoMelhorOfertaVenda;
    private int numeroNegociosEfetuados;
    private Long quantidadeTotalTitulosNegociados;
    private Double volumeTotalTitulosNegociados;
    private Double precoExercicioMercadoOpcoes;
    private int indicadorCorrecaoPreco;
    private Date dataVencimentoMercadoOpcoesTermoSecundario;
    private int fatorCotacaoPapel;
    private Double precoExercicioPontos;
    private String isin;
    private int numeroDistribuicaoPapel;



}
