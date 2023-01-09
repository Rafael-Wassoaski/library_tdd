package com.rafaelwassoaski.library_tdd.entity;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rafaelwassoaski.library_tdd.LibraryTddApplication;
import com.rafaelwassoaski.library_tdd.entity.Emprestimo;
import com.rafaelwassoaski.library_tdd.entity.Livro;
import com.rafaelwassoaski.library_tdd.entity.Usuario;

@SpringBootTest(classes = LibraryTddApplication.class)
public class EmprestimoTest {
    
    //teste de unidade
    @Test
    public void deveriaAplicarMultaCasoOLivroSejaDevolvidoComAtraso(){
        Livro livroEmprestado = new Livro("Java 11");
        Usuario usuario = new Usuario("João", "123");
        Emprestimo emprestimo = new Emprestimo(livroEmprestado, usuario, LocalDate.of(2000, 1, 1));

        emprestimo.devolver();

        boolean deveriaPagarMulta = emprestimo.devePagarMulta();

        Assertions.assertTrue(deveriaPagarMulta);
    }

    @Test
    public void naoDeveriaAplicarMultaQuandoOLivroEhDevolvidoAntesDeCincoDias(){
        Livro livroEmprestado = new Livro("Java 11");
        Usuario usuario = new Usuario("João", "123");
        Emprestimo emprestimo = new Emprestimo(livroEmprestado, usuario, LocalDate.now());

        emprestimo.devolver();

        boolean deveriaPagarMulta = emprestimo.devePagarMulta();

        Assertions.assertFalse(deveriaPagarMulta);
    }


    @Test
    public void aDataDeDevolucaoDeveriaSerADataAtual(){
        Livro livroEmprestado = new Livro("Java 11");
        Usuario usuario = new Usuario("João", "123");
        Emprestimo emprestimo = new Emprestimo(livroEmprestado, usuario, LocalDate.of(2000, 1, 1));
        Long dataAtual = LocalDate.now().toEpochDay();

        emprestimo.devolver();
        Long dataDeDevolucao = emprestimo.getDataDaDevolução().toEpochDay();

        Assertions.assertTrue(dataDeDevolucao >= dataAtual);
    }
}
