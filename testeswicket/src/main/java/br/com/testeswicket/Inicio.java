package br.com.testeswicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class Inicio extends BasePage{
	private static final long serialVersionUID = 502327979204314267L;
	
	public Inicio(){
		Label labelMensagemBoasVindas = new Label("mensagemBoasVindas", Model.of("Hello World Wicket moda foca !"));
		add(labelMensagemBoasVindas);
	}

}
