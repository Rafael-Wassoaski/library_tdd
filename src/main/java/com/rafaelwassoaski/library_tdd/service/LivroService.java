package com.rafaelwassoaski.library_tdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafaelwassoaski.library_tdd.entity.Livro;
import com.rafaelwassoaski.library_tdd.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void salvarLivro(String nomeDoLivro) {
        Livro livro = new Livro(nomeDoLivro);

        livroRepository.save(livro);
    }

    public Livro buscarPorNome(String nomeDoLivro) {
        return livroRepository.findByNome(nomeDoLivro);
    }


    
}
