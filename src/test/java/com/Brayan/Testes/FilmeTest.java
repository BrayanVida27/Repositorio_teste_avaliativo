package com.Brayan.Testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class FilmeTest {

    /**
     * como cinema
     * Eu quero broquear a entrada para de idade
     * para seguir e classificacão indicada
     *
     * Faixa etaria for igual a 18
     * parmitir apenas 18+
     *
     * Faixa etária for igual L
     * permitir todas idade.
     * **/

    @Test
    @DisplayName("Entrada do filme liberada")
    Void deveEntradaLiberada(){
        FaixaEntrada deveService = new FaixaEntrada();
        double faixa = deveService.idadeMinimaEntradaFilme(18);
        assertEquals(18, faixa);
    }
}
