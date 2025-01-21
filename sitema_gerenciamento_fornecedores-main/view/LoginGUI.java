package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Interface gráfica da tela de login.
 * Classe que possui métodos getters e setters dos estados gerenciados nessa tela (login e senha do usuário).
 * Possui tamém métodos para associação dos ouvintes para as funções de limpar campos e enviar dados
 * 
 * @author Bruna Assayag
 * @author Higor Lachini
 * @author João Pedro
 */
public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JTextField loginField;
	private JPasswordField senhaField;
	private JButton btnLimpar;
	private JButton btnEntrar;
	
	public LoginGUI() {
		setTitle("LOGIN");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		Font fonte = new Font("Tahoma", Font.PLAIN, 14);
				
		lblLogin = new JLabel("Login");
		lblLogin.setFont(fonte);
		lblLogin.setBounds(30, 27, 48, 22);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(fonte);
		lblSenha.setBounds(30, 91, 48, 22);
		
		loginField = new JTextField();
		loginField.setBounds(30, 55, 200, 25);
		loginField.setColumns(10);
		
		senhaField = new JPasswordField();
		senhaField.setBounds(30, 117, 200, 25);
		senhaField.setColumns(10);		
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(30, 170, 90, 25);

		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(130, 170, 90, 25);
		
		setLayout(null);

		getContentPane().add(lblLogin);
		getContentPane().add(loginField);
				
		getContentPane().add(lblSenha);
		getContentPane().add(senhaField);
		
		getContentPane().add(btnLimpar);
		getContentPane().add(btnEntrar);
	}
	
	public String getLogin() {
		return loginField.getText();
	}
	public void setLogin(String l) {
		this.loginField.setText(l);
	}
	
	public String getSenha() {
		return String.valueOf(senhaField.getPassword());
	}
	public void setSenha(String s) {
		this.senhaField.setText(s);
	}

	 /**
	  * Atribui listeners aos botões de limpar e de entrar no sistema com seu devido comportamento.
	  * 
	  * @see ControllerLogin
	  */
	public void limpar(ActionListener ouvirLimpar) { //add ouvinte 'limpar'
		btnLimpar.addActionListener(ouvirLimpar);		
	}
	public void entrar(ActionListener ouvirEntrar) { //add ouvinte 'entrar'
		btnEntrar.addActionListener(ouvirEntrar);
	}
}