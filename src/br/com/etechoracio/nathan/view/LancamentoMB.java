package br.com.etechoracio.nathan.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.etechoracio.nathan.business.LancamentoSB;
import br.com.etechoracio.nathan.model.Lancamento;

@Scope("view")
@Controller
public class LancamentoMB {

	private Lancamento edit = new Lancamento();
	@Autowired
	private LancamentoSB lancamentoSB;
	private List<Lancamento> resultado;
	private String Msg;
		
	public List<Lancamento> getResultado() {
		return resultado;
	}

	public void setResultado(List<Lancamento> resultado) {
		this.resultado = resultado;
	}

	public Lancamento getEdit() {
		return edit;
	}

	public void setEdit(Lancamento edit) {
		this.edit = edit;
	}

	public void doSave() {
		lancamentoSB.insert(edit);
		if(Msg == "Edicao"){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Lançamento editado com sucesso."));
			Msg = "";
		}
		else{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Lançamento inserido com sucesso."));
		}
		
		resultado = lancamentoSB.findAll();
	}
	@PostConstruct
	public void postConstruct(){
		resultado = lancamentoSB.findAll();
	}
	public void doRemove(Lancamento exclui){
		lancamentoSB.remove(exclui);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Lançamento excluido com sucesso"));
		resultado = lancamentoSB.findAll();
	}
	public void doPrepareEdicao(Lancamento editar) {
		this.edit = editar;
		Msg = "Edicao";
		
	}
	
	public void doPrepareInsert() {
		this.edit = new Lancamento();
		
	}
	
}
