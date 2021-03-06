package com.dev22.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.dev22.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date dataPagamento;
	
	
	
	public PagamentoComBoleto() {
		// TODO Auto-generated constructor stub
	}



	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super();	
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}



	public Date getDataVencimento() {
		return dataVencimento;
	}



	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}



	public Date getDataPagamento() {
		return dataPagamento;
	}



	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
}
