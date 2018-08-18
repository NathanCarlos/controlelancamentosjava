package br.com.etechoracio.nathan.model;


import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Lancamento")
public class Lancamento {
	@Id
	@GeneratedValue
	@Column(name="id_lanc")
	private Long id;
	
	@Column(name="desc_lanc")
	private String descricao;
	
	@Column(name="valor_lanc")
	private Float valor;
	@Column(name="data_lanc")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@Column(name="dt_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_criacao;
	@PrePersist
	protected void dt_criacao(){
		dt_criacao = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getDt_criacao() {
		return dt_criacao;
	}
	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}
	
	
}
