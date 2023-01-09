package com.rafaelwassoaski.library_tdd.service;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import com.rafaelwassoaski.library_tdd.entity.Usuario;
import com.rafaelwassoaski.library_tdd.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Lazy
    private PasswordEncoder userEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNome(username);
        Usuario usuario = usuarioOptional.get();
        

        return User.builder()
            .username(usuario.getNome())
            .password(usuario.getSenha())
            .roles(usuario.getAutorizacao())
            .build();
    }

    public void criarUsuario(String nome, String senha) {
        String senhaEncriptada = userEncoder.encode(senha);
        Usuario usuario = new Usuario(nome, senhaEncriptada);

        usuarioRepository.save(usuario);
    }
}