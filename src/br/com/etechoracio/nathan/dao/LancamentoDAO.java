package br.com.etechoracio.nathan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.nathan.model.Lancamento;

public interface LancamentoDAO extends JpaRepository<Lancamento, Long>{

}
