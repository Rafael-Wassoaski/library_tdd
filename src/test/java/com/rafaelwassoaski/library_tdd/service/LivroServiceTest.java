package com.rafaelwassoaski.library_tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rafaelwassoaski.library_tdd.LibraryTddApplication;
import com.rafaelwassoaski.library_tdd.entity.Livro;
import com.rafaelwassoaski.library_tdd.service.LivroService;

@SpringBootTest(classes = LibraryTddApplication.class)
public class LivroServiceTest {

    @Autowired
    LivroService livroService;

    @Test
    public void deveriaSerCapazDeProcurarUmLivroPeloNome(){
        // LivroService livroService = new LivroService();
        String nomeDoLivro = "Java 11";
        livroService.salvarLivro(nomeDoLivro);

        Livro livro = livroService.buscarPorNome(nomeDoLivro);

        assertNotNull(livro);
        assertEquals(nomeDoLivro, livro.getNome());
    }
    
}
