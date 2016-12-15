package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Bean (POJO) que representa um Item de Pedido. */

@Entity
@Table(name="tb_item_pedido")
public class ItemPedido{
	
	/** Id do Item. */
	
	@Id
	@Column(name="idItem",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** Quantidade do item. */
	
	private int quantidade;
	
	/** Produto relacionado ao item. */
	
	@ManyToOne
	@JoinColumn(name="idProduto",nullable=false)
	private Produto produto;
	
	/** Pedido a que pertence o item. */
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPedido",nullable=false)
	
	private Pedido pedido;

	/** Retorna o valor total (sem desconto) de um item.
	 *  @return Valor total de um item. */
	
	public double getTotalSemDesconto() {
		double total = 0.0f;
		if (produto != null) {
			total =
				produto.getValor() * quantidade;
		}
		return total;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
}
