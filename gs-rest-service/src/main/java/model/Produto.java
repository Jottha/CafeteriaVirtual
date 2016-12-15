package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Bean (POJO) que representa um Produto. */

@Entity
@Table(name="tb_produto")
public class Produto {
	
	/** Id do Produto. */
	
	@Id
	@Column(name="idProduto",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** Descricao do Produto. */
	
	private String descricao;
	
	/** Valor unitario do Produto. */ 
	
	private double valor;
	
	/** Retorna uma String que representa o Produto.
	 *  @return Descricao do Produto. */
	@Override
	public String toString() {
		return descricao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
		
}
