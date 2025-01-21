package model;

/**
 * Armazena os pares de login e senha cadastrados.
 * 
 * @author Bruna Assayag
 * @author Higor Lachini
 * @author João Pedro
 */
public class Dados {
	public static final String[] login = {"admin", "user"};
	public static final String[] senha = {"123", "12345"};
	
	 /**
	  * Efetua a validação de login e senha inseridos, retorna booleano indicando se validação foi bem sucedida.
	  * 
	  * @param l   Login
	  * @param s   Senha
	  * @return    verdadeiro se o par está cadastrado, senão, falso;
	  */
	public static boolean isLoginSenha(String l, String s) {
		int i;
		for(i=0;i<login.length;i++) {
			if(l.equals(login[i]) && s.equals(senha[i])) {
				return true;
			}
		}
		return false;
	}
}