package br.com.paperbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paperbook.domain.DetalhePedido;

public interface DetalhePedidoRepository extends JpaRepository<DetalhePedido, Integer>{

}
