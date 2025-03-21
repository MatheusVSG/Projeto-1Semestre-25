package com.projeto1.api_spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto1.api_spring.domain.cliente.ClienteService;
import com.projeto1.api_spring.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteservice;

    private final List<Cliente> clientes = new ArrayList<>();
    private Integer idCount = 1;

    @PostMapping("/criar-cliente")
    public String criarCliente(@RequestBody Cliente cliente ) {

        cliente.setId(idCount++);
        clientes.add(cliente);
       
        return "O cliente "+cliente.getNome()+" de idade "+cliente.getIdade()+" Do endereço: "+cliente.getEndereco()+" Foi criado";
    }

    @GetMapping("/ListarCliente")
    public ResponseEntity<List<Cliente>> ListarClientes(){
        var clientes = clienteservice.ListarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @DeleteMapping("/ApagarCliente/{id}")
    public String ApagarClientes(@PathVariable("id") int id){
        for(Cliente cliente: clientes){
        if(cliente.getId()==id){
            clientes.remove(cliente);
            return "Cliente removido com sucesso!";
        }
    }
    return "Não exite cliente com id: " +id;
}

@PutMapping("/AlterarCliente/{id}")
public ResponseEntity<String> AlterarCliente(@PathVariable("id") int id, @RequestBody Cliente clienteAtualizado){
for(Cliente cliente : clientes){
    if(cliente.getId() == id){
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setIdade(clienteAtualizado.getIdade());
        cliente.setEndereco(clienteAtualizado.getEndereco());

        return ResponseEntity.ok("Cliente atualizado com sucesso!");

    }
}

return ResponseEntity.status(404).body("Não existe cliente com id: " + id);

}

}
