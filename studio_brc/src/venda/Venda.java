package venda;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import clientes.Clientes;
import Produto.Produto;

@Entity
@Table(name="venda")
public class Venda {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Clientes Cliente;
	
	@ManyToOne
	@JoinColumn(name="id_produto", nullable=false)	
	private Produto Produto;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clientes getCliente() {
		return Cliente;
	}

	public void setCliente(Clientes cliente) {
		Cliente = cliente;
	}

	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto produto) {
		Produto = produto;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	@Column(name="data_venda")
	private Date data_venda;
	
	
	
	
	
	
	
	
	

}
