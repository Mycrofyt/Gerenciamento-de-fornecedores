package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Fornecedor;
import model.Usuario;
import view.FornecedorGUI;
import view.LoginGUI;

 
/**
 * Controlador da tela de login.
 * A classe possui um construtor para alocar em seus atributos o modelo de usuário e a tela de login.
 * 
 * Também possui um método para definição de lógica de eventos da tela de login,
 * lá é definido o comportamento dos botões LIMPAR e ENVIAR.
 * 
 * @see Usuario
 * @see LoginGUI
 * @see Fornecedor
 * @see FornecedorGUI
 * @see ControllerFornecedor
 * 
 * @author Bruna Assayag
 * @author Higor Lachini
 * @author João Pedro
 */

public class ControllerLogin {
	private Usuario model;
	private LoginGUI loginView;
	
	public ControllerLogin(Usuario model, LoginGUI logView) {
		this.model = model;
		this.loginView = logView;
		
		this.loginView.limpar(new OuvinteLogin());
		this.loginView.entrar(new OuvinteLogin());
	}
	
	/**
	 * Método que contém a lógica de comportamento dos botões da tela de gerenciamento de fornecedores.
	 * 
	 * A opção 'ENVIAR' efetua a validação dos campos de login e senha e entra no sistema caso estejam corretos.
	 * 
	 * A opção 'LIMPAR' limpa todos os campos da tela de login.
	 */
	class OuvinteLogin implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//BOTÃO ENTRAR
			if(e.getActionCommand()=="ENTRAR") {
				if(model.validacao(loginView.getLogin(), loginView.getSenha())) {
					loginView.dispose();
					Fornecedor modelForn = new Fornecedor();
					FornecedorGUI cadastroView = new FornecedorGUI();
					
					new ControllerFornecedor(modelForn, cadastroView);
					cadastroView.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(loginView, "Login ou senha inválidos!", "ERRO", JOptionPane.ERROR_MESSAGE);					
				}
			}
			
			//BOTÃO LIMPAR
			else if(e.getActionCommand()=="LIMPAR") {
				loginView.setLogin("");
				loginView.setSenha("");
			}
		}
		
	}

}