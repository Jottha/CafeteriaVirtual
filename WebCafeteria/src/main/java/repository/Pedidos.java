package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Long> {

}
