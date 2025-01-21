package model;

/**
 * Modelo de um Usuário no sistema.
 * Classe que possui métodos construtor, getters e setters para todos os atributos de um Usuário.
 * 
 * Além disso, possui um método estático para validação de todos os dados de um fornecedor que é usado 
 * no momento de instanciação de um usuário ( @see ControllerLogin ).
 * 
 * 
 * @author Bruna Assayag
 * @author Higor Lachini
 * @author João Pedro
 */
public class Usuario {
	private String login;
	private String senha;

	public Usuario(String l, String s) {
		this.login=l;
		this.senha=s;
	}

	public Usuario() {}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	 /**
	  * Chama a função isLoginSenha da classe Dados, verificando se o login e senha estão cadastrados,
	  * retorna booleano indicando se validação foi bem sucedida.
	  * 
	  * @param l   Login
	  * @param s   Senha
	  * @see 	   Dados
	  * @return    verdadeiro se o par está cadastrado, senão, falso;
	  */
	public boolean validacao(String l, String s) {
		if(Dados.isLoginSenha(l,s))
			return true;
		else
			return false;
	}

}