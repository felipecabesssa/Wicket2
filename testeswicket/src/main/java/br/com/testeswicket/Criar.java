package br.com.testeswicket;

import org.apache.wicket.markup.html.basic.Label;

public class Criar  extends BasePage{
	private static final long serialVersionUID = -6619311231415722854L;
	
	public Criar(){
		add(new Label("titulo", "Criação de Contato"));
	}

}
