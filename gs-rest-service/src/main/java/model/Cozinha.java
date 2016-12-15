package model;

import java.util.ArrayList;
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

/**  Bean (POJO) que representa uma Cozinha. */

@Entity
@Table(name="tb_cozinha")
public class Cozinha {
	
	/** Id da Cozinha. */
	
	@Id
	@Column(name="idCozinha",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** Nome da Cozinha. */
	private String nome;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	/** Garcom que efetuou o pedido. */
	
	@ManyToOne
	@JoinColumn(name="idGarcom",nullable=false)
	private Garcom garcom;
	
	/** Produtos em estoque. */
	
	@ManyToOne
	@JoinColumn(name="idProduto",nullable=false)
	Produto produto;
	
	/** Pedidos na cozinha. */
	
	@ManyToOne
	@JoinColumn(name="idPedido",nullable=false)
	Pedido pedido;
	
	/** Indica se produto esta' disponivel. */
	
	private boolean produtoDisponivel;
	
	/** Indica se pedido sera' aceito ou não. */
	
	private boolean decisaoPedido;
	
	/** Produtos que compoem a cozinha. */
	
	@OneToMany(mappedBy="produto",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	/** Adiciona um produto no estoque.
	 *  @param produto Produto a ser adicionado. */
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	/** Remove um produto do estoque.
	 *  @param produto Produto a ser removido. */
	
	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	/** Remove todos os produtos do estoque. */
	
	public void clearProdutos() {
		produtos.clear();
	}
	
	public boolean produtoDisponivel() {
		return produtoDisponivel;
	}
	
	public void setProdutoDisponivel(boolean produtoDisponivel) {
		this.produtoDisponivel = produtoDisponivel;
	}
	
	public boolean decisaoPedido() {
		return decisaoPedido;
	}
	
	public void setDecisaoPedido(boolean decisaoPedido) {
		this.decisaoPedido = decisaoPedido;
	}
	
	public void setProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProduto() {
		return produtos;
	}
	
	public Garcom getGarcom() {
		return garcom;
	}
	
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
}
