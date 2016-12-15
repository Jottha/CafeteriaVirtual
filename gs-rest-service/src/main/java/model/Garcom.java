package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Bean (POJO) que representa um Garcom. */

@Entity
@Table(name="tb_garcom")
public class Garcom {
	
	/** Id do Garcom. */
	
	@Id
	@Column(name="idGarcom",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** Nome do Garcom. */
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
	
}
