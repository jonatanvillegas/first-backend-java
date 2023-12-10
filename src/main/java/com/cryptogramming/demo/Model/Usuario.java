package com.cryptogramming.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;   

@Document(collection = "usuario")
public class Usuario {
    
    @Id
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String correo;

    public Usuario(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Usuario() {

    }
}
