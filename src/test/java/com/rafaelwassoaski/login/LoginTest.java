package com.rafaelwassoaski.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rafaelwassoaski.library_tdd.LibraryTddApplication;
import com.rafaelwassoaski.library_tdd.service.UsuarioService;

@SpringBootTest(classes = LibraryTddApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoginTest {
    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void deveriaFazerLoginNoSistemaSemErros() {
        String nomeDoUsuario = "Teste";
        String senha = "12345678";
       
        usuarioService.criarUsuario(nomeDoUsuario, senha);

        LoginTestPage pageObject = new LoginTestPage();

        pageObject.fazerLogin(nomeDoUsuario, senha);

        assertTrue(pageObject.estaNaPaginaHome());

        pageObject.finalizar();
    }

}
