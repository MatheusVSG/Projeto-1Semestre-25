package com.projeto1.api_spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.api_spring.entities.Cliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
 
    @PostMapping("/criar-cliente")
    public String criarCliente(@RequestBody Cliente cliente ) {
       
        return "O cliente "+cliente.getNome()+" de idade "+cliente.getIdade()+" Do endereço: "+cliente.getEndereco()+" Foi criado";
    }
    
}
