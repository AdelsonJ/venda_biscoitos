package visao;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import controle.*;
import modelo.*;


public class visaoCliente extends JFrame {
	private Cliente cliente = new Cliente();
	private static visaoCliente uniqueInstance;


	public visaoCliente( ){
		setSize(400, 300);
		setTitle("BITSCOITO");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		
		setLayout(new FlowLayout());
		
		getContentPane().setBackground(new Color(65,26,13));

		//menu(controle);
    }

	public static visaoCliente getInstance( ){
		if(uniqueInstance == null)
			uniqueInstance = new visaoCliente();
		return uniqueInstance;
	}

	public void menu(Controle controle){
		setSize(400,300);
		setLayout(new FlowLayout());
		setVisible(true);

		//CRIACAO DA PRIMEIRA ESCOLHA
        JButton bt_inserir = new JButton("INSERIR");
		add(bt_inserir);
        bt_inserir.setPreferredSize(new Dimension(250,50));
		bt_inserir.setFont(new Font("ARIAL", Font.BOLD, 25));

        JButton bt_excluir = new JButton("EXCLUIR");
		add(bt_excluir);
        bt_excluir.setPreferredSize(new Dimension(250,50));
		bt_excluir.setFont(new Font("ARIAL", Font.BOLD, 25));
        
        JButton bt_visualizar = new JButton("VISUALIZAR");
		add(bt_visualizar);
        bt_visualizar.setPreferredSize(new Dimension(250,50));
		bt_visualizar.setFont(new Font("ARIAL", Font.BOLD, 25));
        
        JButton bt_voltar = new JButton("VOLTAR");
		add(bt_voltar);
        bt_voltar.setPreferredSize(new Dimension(250,50));
		bt_voltar.setFont(new Font("ARIAL", Font.BOLD, 25));

		bt_inserir.setBackground(new Color(175,87,0));
		bt_excluir.setBackground(new Color(175,87,0));
		bt_visualizar.setBackground(new Color(175,87,0));
		bt_voltar.setBackground(new Color(175,87,0));
		bt_inserir.setForeground(new Color(65,26,13));
		bt_excluir.setForeground(new Color(65,26,13));
		bt_visualizar.setForeground(new Color(65,26,13));
		bt_voltar.setForeground(new Color(65,26,13));

		//CRIACAO DA ESCOLHA A PARTIR DO CLIENTE	
		bt_inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_inserir);
				remove(bt_excluir);
				remove(bt_visualizar);
				remove(bt_voltar);

				menu_inserir(controle);
				
			}
		});

		//CRIACAO DA ESCOLHA A PARTIR DO CLIENTE	
		bt_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_inserir);
				remove(bt_excluir);
				remove(bt_visualizar);
				remove(bt_voltar);

				menu_excluir(controle);
				
			}
		});

		//CRIACAO DA ESCOLHA A PARTIR DO CLIENTE	
		bt_visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_inserir);
				remove(bt_excluir);
				remove(bt_visualizar);
				remove(bt_voltar);

				menu_visualizar(controle);
				
			}
		});
		
		//CRIACAO DA ESCOLHA A PARTIR DO CLIENTE	
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_inserir);
				remove(bt_excluir);
				remove(bt_visualizar);
				remove(bt_voltar);

				visaoMain.getInstance().menu();

                setVisible(false);
			}
		});
		
    }


	public void menu_inserir(Controle controle){
		setSize(500,500);
		setLayout(null);

		JLabel nome = new JLabel("NOME: ");
		add(nome);
		nome.setBounds(0,0,100,25);
		nome.setLocation(102, 10);

		JTextField recebe_nome = new JTextField("");
		recebe_nome.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_nome);

		recebe_nome.setBounds(0,0,250,25);
		recebe_nome.setLocation(160, 10);


		JLabel saldo = new JLabel("SALDO: ");
		add(saldo);
		saldo.setBounds(0,0,100,25);
		saldo.setLocation(96, 40);

		JTextField recebe_saldo = new JTextField("");
		recebe_saldo.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_saldo);

		recebe_saldo.setBounds(0,0,250,25);
		recebe_saldo.setLocation(160, 40);


		JButton inserir = new JButton("INSERIR");
		add(inserir);
		inserir.setFont(new Font("ARIAL", Font.BOLD, 14));
		inserir.setBounds(0,0,100,25);
		inserir.setLocation(350, 70);


		JTextArea visualizar_cliente = new JTextArea(((ControleCliente)controle).devolve_string());
		visualizar_cliente.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_cliente);

		visualizar_cliente.setBounds(0,0,450,280);
		visualizar_cliente.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_cliente);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		//scroll.setViewportView(panelInsNotGrup);
		scroll.setVisible(true);
		scroll.setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25,135, 450,310);
		scroll.getVerticalScrollBar().setValue(0);
		getContentPane().add(scroll);

		inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setNome(recebe_nome.getText());
				cliente.setSaldo(Float.parseFloat(recebe_saldo.getText()));
				
				recebe_nome.setText("");
        		recebe_nome.requestFocus();
				recebe_saldo.setText("");
        		recebe_saldo.requestFocus();

				((ControleCliente)controle).inserir(cliente);

				visualizar_cliente.setText(((ControleCliente)controle).devolve_string());
				visualizar_cliente.requestFocus();

			}
		});
		
		JButton voltar = new JButton("VOLTAR");
		add(voltar);
		voltar.setFont(new Font("ARIAL", Font.BOLD, 14));
		voltar.setBounds(0,0,100,25);
		voltar.setLocation(50, 70);

		nome.setForeground(new Color(175,87,0));
		saldo.setForeground(new Color(175,87,0));

		inserir.setBackground(new Color(175,87,0));
		inserir.setForeground(new Color(65,26,13));
		voltar.setBackground(new Color(175,87,0));
		voltar.setForeground(new Color(65,26,13));

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(inserir);
				remove(nome);
				remove(saldo);
				remove(recebe_nome);
				remove(recebe_saldo);
				remove(voltar);
				remove(scroll);
				menu(controle);				
			}
		});


		//JTextField tf = new JTextField("Digite aqui");
		//tf.setFont(new Font("Times", Font.BOLD, 28 ));
		//add(tf);
	}


	public void menu_excluir(Controle controle){
		setSize(500,500);
		setLayout(null);

		JLabel cabecario = new JLabel("DESEJA EXCLUIR USANDO ID OU NOME?");
		add(cabecario);
		cabecario.setBounds(0,0,350,25);
		cabecario.setLocation(100, 10);


		JLabel id = new JLabel("ID: ");
		add(id);
		id.setBounds(0,0,100,25);
		id.setLocation(95, 40);

		JTextField recebe_id = new JTextField("");
		recebe_id.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_id);
		recebe_id.setBounds(0,0,200,25);
		recebe_id.setLocation(130, 40);


		JLabel ou = new JLabel("OU");
		add(ou);
		ou.setBounds(0,0,100,25);
		ou.setLocation(215, 70);


		JLabel nome = new JLabel("NOME: ");
		add(nome);
		nome.setBounds(0,0,100,25);
		nome.setLocation(68, 100);

		JTextField recebe_nome = new JTextField("");
		recebe_nome.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_nome);
		recebe_nome.setBounds(0,0,200,25);
		recebe_nome.setLocation(130, 100);

		
		JButton inserir = new JButton("EXCLUIR");
		add(inserir);
		inserir.setFont(new Font("ARIAL", Font.BOLD, 14));
		inserir.setBounds(0,0,100,25);
		inserir.setLocation(350, 40);

		JButton inserir2 = new JButton("EXCLUIR");
		add(inserir2);
		inserir2.setFont(new Font("ARIAL", Font.BOLD, 14));
		inserir2.setBounds(0,0,100,25);
		inserir2.setLocation(350, 100);

		JTextArea visualizar_cliente = new JTextArea(((ControleCliente)controle).devolve_string());
		visualizar_cliente.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_cliente);

		visualizar_cliente.setBounds(0,0,450,280);
		visualizar_cliente.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_cliente);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		//scroll.setViewportView(panelInsNotGrup);
		scroll.setVisible(true);
		scroll.setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25,190, 450,265);
		scroll.getVerticalScrollBar().setValue(0);
		getContentPane().add(scroll);

		inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ControleCliente)controle).remover(Integer.parseInt(recebe_id.getText()),null);
				recebe_id.setText("");
        		recebe_id.requestFocus();
				visualizar_cliente.setText(((ControleCliente)controle).devolve_string());
				visualizar_cliente.requestFocus();
			}
		});

		inserir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ControleCliente)controle).remover(-1,recebe_nome.getText());
				recebe_nome.setText("");
        		recebe_nome.requestFocus();
				visualizar_cliente.setText(((ControleCliente)controle).devolve_string());
				visualizar_cliente.requestFocus();
			}
		});

		
		
		JButton voltar = new JButton("VOLTAR");
		add(voltar);
		voltar.setFont(new Font("ARIAL", Font.BOLD, 14));
		voltar.setBounds(0,0,100,25);
		voltar.setLocation(50, 140);

		cabecario.setForeground(new Color(175,87,0));
		ou.setForeground(new Color(175,87,0));
		nome.setForeground(new Color(175,87,0));
		id.setForeground(new Color(175,87,0));

		inserir.setBackground(new Color(175,87,0));
		inserir.setForeground(new Color(65,26,13));
		inserir2.setBackground(new Color(175,87,0));
		inserir2.setForeground(new Color(65,26,13));
		voltar.setBackground(new Color(175,87,0));
		voltar.setForeground(new Color(65,26,13));

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(cabecario);
				remove(inserir);
				remove(inserir2);
				remove(ou);
				remove(nome);
				remove(id);
				remove(recebe_nome);
				remove(recebe_id);
				remove(voltar);
				remove(scroll);
				menu(controle);				
			}
		});


		//JTextField tf = new JTextField("Digite aqui");
		//tf.setFont(new Font("Times", Font.BOLD, 28 ));
		//add(tf);
	}


	public void menu_visualizar(Controle controle){
		setSize(500,500);
		setLayout(null);
		
		JTextArea visualizar_cliente = new JTextArea(((ControleCliente)controle).devolve_string());
		visualizar_cliente.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_cliente);

		visualizar_cliente.setBounds(0,0,450,280);
		visualizar_cliente.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_cliente);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		//scroll.setViewportView(panelInsNotGrup);
		scroll.setVisible(true);
		scroll.setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25,15, 450,375);
		scroll.getVerticalScrollBar().setValue(0);
		getContentPane().add(scroll);

		JButton voltar = new JButton("VOLTAR");
		add(voltar);
		voltar.setFont(new Font("ARIAL", Font.BOLD, 14));
		voltar.setBounds(0,0,100,25);
		voltar.setLocation(200, 410);

		voltar.setBackground(new Color(175,87,0));
		voltar.setForeground(new Color(65,26,13));

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(voltar);
				remove(scroll);
				menu(controle);				
			}
		});
	}


	
}

