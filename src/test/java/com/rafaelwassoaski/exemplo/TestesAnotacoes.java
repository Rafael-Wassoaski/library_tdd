package com.rafaelwassoaski.exemplo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestesAnotacoes {

    @BeforeAll
    public static void antesDeTudo() {
        System.out.println("Sou um método que roda uma vez antes de tudo");
    }

    @BeforeEach
    public void umaVezAntesDeCada() {
        System.out.println("Sou um método que roda uma vez antes de cada teste");
    }

    @AfterAll
    public static void depoisDeTudo() {
        System.out.println("Sou um método que roda só uma vez após todos os testes");
    }

    @AfterEach
    public void umaVezDepoisDeCada() {
        System.out.println("Sou um método que roda uma vez após cada teste");
    }

    @Test
    public void testeExemplo1() {
        assertTrue(true);
    }

    @Test
    public void testeExemplo2() {
        assertFalse(false);
    }

    @Test
    public void testeExemplo3() {
        assertTrue(true);
    }

    @Test
    public void testeExemplo4() {
        assertFalse(false);
    }
}
