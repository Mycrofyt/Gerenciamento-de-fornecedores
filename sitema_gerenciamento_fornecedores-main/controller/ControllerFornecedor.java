package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Fornecedor;
import model.Usuario;
import view.FornecedorGUI;
import view.LoginGUI;

/**
 * Controlador da tela de fornecedores.
 * A classe possui um construtor para alocar em seus atributos o modelo de fornecedor 
 * e a tela de gerenciamento de fornecedores.
 * 
 * Também possui um método para definição de lógica de eventos da tela de login,
 * lá é definido o comportamento dos botões LIMPAR e ENVIAR(valida e cadastra novo fornecedor).
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
public class ControllerFornecedor {
	
	@SuppressWarnings("unused")
	private Fornecedor model;
	private FornecedorGUI cadastroView;
	private ArrayList<Fornecedor> fornecedores;
	
	public ControllerFornecedor(Fornecedor model, FornecedorGUI cadView) {
		this.model = model;
		this.cadastroView = cadView;
		this.fornecedores = new ArrayList<Fornecedor>();
		
		this.cadastroView.limpar(new OuvinteCadastro());
		this.cadastroView.enviar(new OuvinteCadastro());
	}
	
	/**
	 * Método que contém a lógica de comportamento dos botões da tela de gerenciamento de fornecedores.
	 * 
	 * A opção 'ENVIAR' efetua a validação dos campos de um fornecedor, que caso não sejam válidos retornam uma caixa
	 * de texto informando ao usuário, e caso contrário, registra um novo fornecedor no sistema.
	 * 
	 * A opção 'LIMPAR' limpa todos os campos de cadastro de fornecedor
	 */
	class OuvinteCadastro implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "ENVIAR") {
				String cnpj = cadastroView.getCnpj();
				String nome = cadastroView.getNome();
				String numero = cadastroView.getNumero();
				String logradouro = cadastroView.getLogradouro();
				String cidade = cadastroView.getCidade();
				String estado = cadastroView.getEstadoSelecionado();
				String telefone = cadastroView.getTelefone();
				
				Map<String, Boolean> validacao = Fornecedor.validarDados(
					cnpj, 
					nome, 
					numero, 
					logradouro, 
					cidade, 
					estado, 
					telefone
				);
				
				if(!validacao.get("cnpj").booleanValue())
					JOptionPane.showMessageDialog(cadastroView, "Preencha o CNPJ com 14 dígitos, apenas números", "ERRO", JOptionPane.ERROR_MESSAGE);
				else if(!validacao.get("nome").booleanValue()) {
					JOptionPane.showMessageDialog(cadastroView, "'Nome' é um campo obrigatório!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validacao.get("logradouro").booleanValue()) {
					JOptionPane.showMessageDialog(cadastroView, "'Logradouro' é um campo obrigatório!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validacao.get("numero").booleanValue()) {
					JOptionPane.showMessageDialog(cadastroView, "Apenas números no campo 'Número'", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validacao.get("cidade").booleanValue()) {
					JOptionPane.showMessageDialog(cadastroView, "'Cidade' é um campo obrigatório!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validacao.get("estado").booleanValue()) {
					JOptionPane.showMessageDialog(cadastroView, "Por favor, selecione um estado!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else if(!validacao.get("telefone").booleanValue()) {
					JOptionPane.showMessageDialog(cadastroView, "Apenas números no campo 'Telefone'.", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Fornecedor novoFornecedor = new Fornecedor(cnpj,nome,logradouro,numero,cidade,estado,telefone);
					fornecedores.add(novoFornecedor);
					cadastroView.adicionarDados(novoFornecedor);
					
					JOptionPane.showMessageDialog(cadastroView, "Fornecedor cadastrado com sucesso!");
				}
				
			}
			else if (e.getActionCommand() == "LIMPAR") {
				cadastroView.setCnpj("");
				cadastroView.setCidade("");
				cadastroView.setNome("");
				cadastroView.setNumero("");
				cadastroView.setLogradouro("");
				cadastroView.setTelefone("");
				cadastroView.setEstadoSelecionado(0);
			}
		}

	}
	

}