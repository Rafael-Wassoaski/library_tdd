package com.rafaelwassoaski.library_tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafaelwassoaski.library_tdd.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    
}
