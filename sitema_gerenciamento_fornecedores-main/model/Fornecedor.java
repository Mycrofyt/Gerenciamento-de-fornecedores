package model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Modelo de um Fornecedor no sistema.
 * Classe que possui métodos construtor, getters e setters para todos os atributos de um fornecedor.
 * 
 * Além disso, possui um método estático para validação de todos os dados de um fornecedor que é usado 
 * no momento de instanciação de um fornecedor ( @see ControllerFornecedor ).
 * 
 * 
 * @author Bruna Assayag
 * @author Higor Lachini
 * @author João Pedro
 */

public class Fornecedor {
	private String cnpj;
	private String nome;
	private String logradouro;
	private String numero;
	private String cidade;
	private String estado;
	private String telefone;
	
	
	/**
	 * Constrói um novo fornecedor com os seguintes parâmetros:
	 * 
	 * @param cnpj Número de CNPJ do fornecedor
	 * @param nome Nome do fornecedor
	 * @param logradouro Logradouro do fornecedor
	 * @param numero Número do endereço do fornecedor
	 * @param cidade Cidade do fornecedor
	 * @param estado Estado do fornecedor
	 * @param telefone Número de telefone do fornecedor
	 */
	public Fornecedor(String cnpj, String nome, String logradouro, String numero, String cidade, String estado, String telefone) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
	}

	public Fornecedor() {}

	public String getCnpj() { // formato 12.123.123/1234-12
		return cnpj.charAt(0)+cnpj.charAt(1)+"."+cnpj.charAt(2)+cnpj.charAt(3)+cnpj.charAt(4)+"."+cnpj.charAt(5)+cnpj.charAt(6)+cnpj.charAt(7)+"/"+cnpj.charAt(8)+cnpj.charAt(9)+cnpj.charAt(10)+cnpj.charAt(11)+"."+cnpj.charAt(12)+cnpj.charAt(13);
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public String getEstadoSigla() {
		switch(estado) {
			case ("Espírito Santo"):
				return "ES";
			case ("Minas Gerais"):
				return "MG";
			case ("Rio de Janeiro"):
				return "RJ";
			case ("São Paulo"):
				return "SP";
			default:
				return "";
		}
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	/**
	 * Efetua a validação de todos os campos atribuindo o sucesso da mesma num HashMap que é retornado.
	 * 
	 * @param cnpj Número de CNPJ do fornecedor
	 * @param nome Nome do fornecedor
	 * @param numero Número do endereço do fornecedor
	 * @param logradouro Logradouro do fornecedor
	 * @param cidade Cidade do fornecedor
	 * @param estado Estado do fornecedor
	 * @param telefone Número de telefone do fornecedor
	 * @return Um HashMap contendo o resultado da validação de cada campo
	 */
	public static Map<String, Boolean> validarDados(
			String cnpj, 
			String nome, 
			String numero,
			String logradouro,
			String cidade,
			String estado,
			String telefone
		) {
			Map<String, Boolean> validacao = new HashMap<>();
			
			validacao.put("cnpj", Boolean.FALSE);
			validacao.put("nome", Boolean.FALSE);
			validacao.put("numero", Boolean.FALSE);
			validacao.put("logradouro", Boolean.FALSE);
			validacao.put("cidade", Boolean.FALSE);
			validacao.put("estado", Boolean.FALSE);
			validacao.put("telefone", Boolean.FALSE);
			
			if (Pattern.matches("^[0-9]+$", cnpj) && cnpj.length()==14) {
				validacao.put("cnpj", Boolean.TRUE);
			}
			if (!nome.isBlank()) {
				validacao.put("nome", Boolean.TRUE);
			}
			if (Pattern.matches("^[0-9]+$", numero)) {
				validacao.put("numero", Boolean.TRUE);
			}
			if (!logradouro.isBlank()) {
				validacao.put("logradouro", Boolean.TRUE);
			}
			if (!cidade.isBlank()) {
				validacao.put("cidade", Boolean.TRUE);
			}
			if (!estado.isBlank()) {
				validacao.put("estado", Boolean.TRUE);
			}
			if (Pattern.matches("^[0-9]+$", telefone)) {
				validacao.put("telefone", Boolean.TRUE);
			}
			
			return validacao;
		}
}