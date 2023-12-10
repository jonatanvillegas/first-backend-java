package com.cryptogramming.demo.Service;

import com.cryptogramming.demo.Model.Usuario;
import com.cryptogramming.demo.Repository.UsuarioRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario ActualizarUsuario(String id, Usuario usuario){
        //validando si existe el usuario
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if(usuarioExistente.isPresent()){
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }else{
            throw new NoSuchElementException("No se encontró el usuario con ID: " + id);
        } 
    }

    public void eliminarUsuario(String id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
    
        if (usuarioExistente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado con ID: " + id);
        }
    
        usuarioRepository.deleteById(id);
    }
}
