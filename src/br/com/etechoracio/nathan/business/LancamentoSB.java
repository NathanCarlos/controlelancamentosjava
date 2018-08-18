package br.com.etechoracio.nathan.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.etechoracio.nathan.dao.LancamentoDAO;
import br.com.etechoracio.nathan.model.Lancamento;

@Service
public class LancamentoSB {
	
	@PersistenceContext
	private EntityManager em;
	private LancamentoDAO getDAO(){
		RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
		return factory.getRepository(LancamentoDAO.class);
	}
	
	@Transactional
	public void insert(Lancamento lancamento){
		LancamentoDAO dao = getDAO();
		dao.save(lancamento);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Lancamento> findAll(){
		LancamentoDAO dao = getDAO();
		return dao.findAll();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(Lancamento lancamento){
		LancamentoDAO dao = getDAO();
		Lancamento exclui = em.merge(lancamento);
		dao.delete(exclui);
	}
}
