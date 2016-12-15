package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ItemPedido;

public interface ItensPedidos extends JpaRepository<ItemPedido, Long> {

}
