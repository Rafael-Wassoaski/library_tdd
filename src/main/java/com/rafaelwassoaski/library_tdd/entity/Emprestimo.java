package com.rafaelwassoaski.library_tdd.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Livro livro;
    @OneToOne
    private Usuario usuario;
    @Column
    private LocalDate dataDoEmprestimo;
    @Column
    private LocalDate dataDaDevolução;


    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataDoEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    public Emprestimo(Long id, Livro livro, Usuario usuario, LocalDate dataDoEmprestimo) {
        this(livro, usuario, dataDoEmprestimo);
        this.id = id;
    }

    public void devolver(){
        this.dataDaDevolução = LocalDate.now();
    }


    public boolean devePagarMulta() {
        return ChronoUnit.DAYS.between(dataDoEmprestimo, dataDaDevolução) > 5;
    }


    public Livro getLivro() {
        return livro;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public LocalDate getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }


    public LocalDate getDataDaDevolução() {
        return dataDaDevolução;
    }
}
