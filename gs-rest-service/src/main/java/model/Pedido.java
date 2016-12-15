package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Bean (POJO) que representa um Pedido. */

@Entity
@Table(name="tb_pedido")
public class Pedido {
	
	/** Id do Pedido. */
	
	@Id
	@Column(name="idPedido",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** Data/Hora do pedido. */
	
	private Date data;
	
	/** Indica se pedido ja' foi finalizado. */
	
	private boolean finalizado;
	
	/** Garcom que efetuou o pedido. */
	
	@ManyToOne
	@JoinColumn(name="idGarcom",nullable=false)
	private Garcom garcom;
	
	/** Itens que compoem o pedido. */
	
	@OneToMany(mappedBy="pedido",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	/** Adiciona um item ao pedido.
	 *  @param item Item a ser adicionado. */
	
	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	
	/** Remove um item do pedido.
	 *  @param item Item a ser removido. */
	
	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	
	/** Remove todos os itens do pedido. */
	
	public void clearItens() {
		itens.clear();
	}

	/** Retorna o valor total (sem desconto) de um pedido.
	 *  @return Valor total de um pedido. */
	public float getTotalSemDesconto() {
		float total = 0.0f;
		for (ItemPedido item : itens) {
			total += item.getTotalSemDesconto();
		}
		return total;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Garcom getGarcom() {
		return garcom;
	}
	
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
}
