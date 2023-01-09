package com.rafaelwassoaski.library_tdd.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rafaelwassoaski.library_tdd.entity.Emprestimo;
import com.rafaelwassoaski.library_tdd.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Optional<Usuario> findByNome(String nome);
}
