package com.rafaelwassoaski.library_tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafaelwassoaski.library_tdd.entity.Emprestimo;
import com.rafaelwassoaski.library_tdd.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    public Livro findByNome(String nome);
    
}
