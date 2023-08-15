package br.com.paperbook.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Detalhepedido")
public class DetalhePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddetalhepedido;
	
	@Column
	private Integer quantidade;
	
	@Column
	private Double precounitario;
	
	@Column
	private Double valortotal;
	
	@OneToOne
	@JoinColumn(name="idpedido")
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

	public DetalhePedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalhePedido(Integer iddetalhepedido, Integer quantidade, Double precounitario, Double valortotal,
			Pedido pedido, Produto produto) {
		super();
		this.iddetalhepedido = iddetalhepedido;
		this.quantidade = quantidade;
		this.precounitario = precounitario;
		this.valortotal = valortotal;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getIddetalhepedido() {
		return iddetalhepedido;
	}

	public void setIddetalhepedido(Integer iddetalhepedido) {
		this.iddetalhepedido = iddetalhepedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecounitario() {
		return precounitario;
	}

	public void setPrecounitario(Double precounitario) {
		this.precounitario = precounitario;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
