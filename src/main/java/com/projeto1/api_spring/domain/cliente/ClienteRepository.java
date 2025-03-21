package com.projeto1.api_spring.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto1.api_spring.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
