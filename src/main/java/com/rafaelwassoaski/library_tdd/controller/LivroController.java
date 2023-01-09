package com.rafaelwassoaski.library_tdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rafaelwassoaski.library_tdd.entity.Livro;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @GetMapping("/new")
    public String formularioDeCadastro(Model model){
        Livro livro = new Livro();  
        model.addAttribute("livroForm", livro);

        return "novoLivroForm";
    }
}
