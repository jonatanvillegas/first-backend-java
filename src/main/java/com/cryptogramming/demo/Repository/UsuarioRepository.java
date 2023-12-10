package com.cryptogramming.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cryptogramming.demo.Model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{


}
