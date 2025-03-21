package com.projeto1.api_spring.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.api_spring.entities.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> ListarClientes(){
        return clienteRepository.findAll();
    }
}
