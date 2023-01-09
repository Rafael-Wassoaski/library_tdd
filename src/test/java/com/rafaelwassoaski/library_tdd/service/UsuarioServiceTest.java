package com.rafaelwassoaski.library_tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import com.rafaelwassoaski.library_tdd.LibraryTddApplication;
import com.rafaelwassoaski.library_tdd.service.UsuarioService;

@SpringBootTest(classes = LibraryTddApplication.class)
public class UsuarioServiceTest {
    
    @Autowired
    UsuarioService userService;

    @Test
    public void deveriaCarregarUmUserDetailsPeloNome(){
        String nomeDoUsuario = "Teste";
        userService.criarUsuario(nomeDoUsuario, "12345678");

        UserDetails usuarioEncontrado = userService.loadUserByUsername(nomeDoUsuario);

        assertNotNull(usuarioEncontrado);
        assertEquals(nomeDoUsuario, usuarioEncontrado.getUsername());
    }
}
