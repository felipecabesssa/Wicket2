package br.com.testeswicket;

import java.sql.Connection;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import br.com.testeswicket.contato.Contato;
import br.com.testeswicket.contato.ContatoDAO;

public class Criar  extends BasePage{
	private static final long serialVersionUID = -6619311231415722854L;
	
	public Criar(){
		add(new Label("titulo", "Criação de Contato"));
		
		Contato contato = new Contato();
		CompoundPropertyModel<Contato> compoundPropertyModelContrato = new CompoundPropertyModel<Contato>(contato);
		Form<Contato> form = new Form<Contato>("formularioContato", compoundPropertyModelContrato){
			private static final long serialVersionUID = -1620862938532623698L;
			
			@Override
			public void onSubmit(){
				Contato contatoSubmetido = getModelObject();
				salvar(contatoSubmetido);
				setResponsePage(Inicio.class);
			}

		};
		add(form);
		
		TextField<String> inputNome = new TextField<String>("nome");
		TextField<String> inputEmail = new TextField<String>("email");
		TextField<String> inputTelefone = new TextField<String>("telefone");
		form.add(inputNome, inputEmail, inputTelefone);
	}
	
	private void salvar(Contato contatoSubmetido) {
//		System.out.println("Contato a inserir " + contatoSubmetido);
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.inserir(contatoSubmetido);
	}

}
