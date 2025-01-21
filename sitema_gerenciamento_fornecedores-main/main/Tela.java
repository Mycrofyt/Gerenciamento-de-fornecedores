package main;

import controller.ControllerLogin;
import model.Usuario;
import view.LoginGUI;
/**
 * Classe principal. Serve para incialização do programa e é onde são instanciadas as classes de tela de login, 
 * modelo de usuário e controlador de login.
 * 
 * 
 * @author Bruna Assayag
 * @author Higor Lachini
 * @author João Pedro
 */
public class Tela {

	public static void main(String[] args) {
		Usuario model = new Usuario();
		LoginGUI logGUI = new LoginGUI();
		new ControllerLogin(model, logGUI);
		logGUI.setVisible(true);
	}

}