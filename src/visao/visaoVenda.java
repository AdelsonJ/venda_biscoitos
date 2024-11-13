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


public class visaoVenda extends JFrame {
	private Venda venda = new Venda();
	private Aux aux = new Aux();
	private static visaoVenda uniqueInstance;

	private int guarda_id = 0;
	private String guarda_nome = "";

	public visaoVenda(){
		setSize(400, 300);
		setTitle("BITSCOITO");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		
		setLayout(new FlowLayout());

		getContentPane().setBackground(new Color(65,26,13));

		//menu(controle, controle_aux);
    }

	public static visaoVenda getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new visaoVenda();
		return uniqueInstance;
	}
	 
	public void menu(Controle controle, Controle controle_aux){
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

				menu_inserir(controle, controle_aux);
				
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

				menu_excluir(controle, controle_aux);
				
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

				menu_visualizar(controle, controle_aux);
				
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


	public void menu_inserir(Controle controle, Controle controle_aux){
		
        JButton bt_id = new JButton("ID");
		add(bt_id);
        bt_id.setPreferredSize(new Dimension(250,50));
		bt_id.setFont(new Font("ARIAL", Font.BOLD, 25));

        JButton bt_nome = new JButton("NOME");
		add(bt_nome);
        bt_nome.setPreferredSize(new Dimension(250,50));
		bt_nome.setFont(new Font("ARIAL", Font.BOLD, 25));

        JButton bt_voltar = new JButton("VOLTAR");
		add(bt_voltar);
        bt_voltar.setPreferredSize(new Dimension(250,50));
		bt_voltar.setFont(new Font("ARIAL", Font.BOLD, 25));


		bt_id.setBackground(new Color(175,87,0));
		bt_id.setForeground(new Color(65,26,13));
		bt_nome.setBackground(new Color(175,87,0));
		bt_nome.setForeground(new Color(65,26,13));
		bt_voltar.setBackground(new Color(175,87,0));
		bt_voltar.setForeground(new Color(65,26,13));


        //CRIACAO DA ESCOLHA A PARTIR DO CLIENTE
        bt_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR

				remove(bt_voltar);
				remove(bt_id);
				remove(bt_nome);

				menu_inserir_id(controle, controle_aux);
				
			}
		});

        //CRIACAO DA ESCOLHA A PARTIR DO CLIENTE
        bt_nome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_id);
				remove(bt_nome);
				remove(bt_voltar);

				menu_inserir_nome(controle, controle_aux);
				
			}
		});

        //CRIACAO DA ESCOLHA A PARTIR DO CLIENTE	
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_id);
				remove(bt_nome);
				remove(bt_voltar);

                menu(controle, controle_aux);
			}
		});

		//JTextField tf = new JTextField("Digite aqui");
		//tf.setFont(new Font("Times", Font.BOLD, 28 ));
		//add(tf);
	}

    public void menu_inserir_id(Controle controle, Controle controle_aux){
        setSize(500,500);
		setLayout(null);

		JLabel id_cliente = new JLabel("CLIENTE: ");
		add(id_cliente);
		id_cliente.setBounds(0,0,100,25);
		id_cliente.setLocation(90, 10);

		JTextField recebe_id_cliente = new JTextField("");
		recebe_id_cliente.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_id_cliente);

		recebe_id_cliente.setBounds(0,0,250,25);
		recebe_id_cliente.setLocation(160, 10);


		JLabel id_biscoito = new JLabel("BISCOITO: ");
		add(id_biscoito);
		id_biscoito.setBounds(0,0,100,25);
		id_biscoito.setLocation(80, 40);

		JTextField recebe_id_biscoito = new JTextField("");
		recebe_id_biscoito.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_id_biscoito);

		recebe_id_biscoito.setBounds(0,0,250,25);
		recebe_id_biscoito.setLocation(160, 40);


		JLabel quantidade = new JLabel("QUANTIDADE: ");
		add(quantidade);
		quantidade.setBounds(0,0,100,25);
		quantidade.setLocation(57, 70);

		JTextField recebe_quantidade = new JTextField("");
		recebe_quantidade.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_quantidade);

		recebe_quantidade.setBounds(0,0,250,25);
		recebe_quantidade.setLocation(160, 70);

        JLabel id_embalagem = new JLabel("EMBALAGEM: ");
		add(id_embalagem);
		id_embalagem.setBounds(0,0,100,25);
		id_embalagem.setLocation(60, 100);

		JTextField recebe_id_embalagem = new JTextField("");
		recebe_id_embalagem.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_id_embalagem);

		recebe_id_embalagem.setBounds(0,0,250,25);
		recebe_id_embalagem.setLocation(160, 100);


		JButton adicionar = new JButton("ADICIONAR");
		add(adicionar);
		adicionar.setFont(new Font("ARIAL", Font.BOLD, 14));
		adicionar.setBounds(0,0,120,25);
		adicionar.setLocation(350, 130);

		JLabel valor_final = new JLabel("VALOR FINAL: ");
		add(valor_final);
		valor_final.setBounds(0,0,100,25);
		valor_final.setLocation(57, 420);

		JTextField recebe_valor_final = new JTextField("0,00");
		recebe_valor_final.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_valor_final);
		recebe_valor_final.setBounds(0,0,150,25);
		recebe_valor_final.setLocation(160, 420);

		recebe_valor_final.setEditable(false);
		

		JTextArea visualizar_venda = new JTextArea(((ControleAux)controle_aux).devolve_string());
		visualizar_venda.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_venda);

		visualizar_venda.setBounds(0,0,450,280);
		visualizar_venda.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_venda);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		//scroll.setViewportView(panelInsNotGrup);
		scroll.setVisible(true);
		scroll.setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25,185, 450,210);
		scroll.getVerticalScrollBar().setValue(0);
		getContentPane().add(scroll);


		JButton finalizar = new JButton("FINALIZAR");
		add(finalizar);
		finalizar.setFont(new Font("ARIAL", Font.BOLD, 14));
		finalizar.setBounds(0,0,120,25);
		finalizar.setLocation(350, 420);
		

		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guarda_id = Integer.parseInt(recebe_id_cliente.getText());

				aux.setClienteNome(recebe_id_cliente.getText());
                aux.setClienteQuantidade(Integer.parseInt(recebe_quantidade.getText()));
                aux.setBiscoitoNome(recebe_id_biscoito.getText());
                aux.setEmbalagemTipo(recebe_id_embalagem.getText());
				aux.setEmbalagemCapacidade(-1);

				
				recebe_id_cliente.setText("");
        		recebe_id_cliente.requestFocus();
				recebe_id_biscoito.setText("");
        		recebe_id_biscoito.requestFocus();
				recebe_id_embalagem.setText("");
        		recebe_id_embalagem.requestFocus();
				recebe_quantidade.setText("");
        		recebe_quantidade.requestFocus();

				((ControleAux)controle_aux).inserir(aux);

				recebe_valor_final.setText(Float.toString(((ControleAux)controle_aux).soma()));
        		recebe_valor_final.requestFocus();

				visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        		visualizar_venda.requestFocus();
			}
		});

		finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guarda_id != 0){
					if(((ControleAux)controle_aux).devolve_saldo(guarda_id, "0", -1) > Float.parseFloat(recebe_valor_final.getText())){
						((ControleVenda)controle).inserir(venda);
						((ControleAux)controle_aux).destroi();
						recebe_valor_final.setText("0,00");
						recebe_valor_final.requestFocus();
						visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        				visualizar_venda.requestFocus();
						guarda_id = 0;
					}
					else{
						recebe_valor_final.setText("SALDO INSUFICIENTE");
						recebe_valor_final.requestFocus();
						visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        				visualizar_venda.requestFocus();
					}
				}
			}
		});
		
		JButton voltar = new JButton("VOLTAR");
		add(voltar);
		voltar.setFont(new Font("ARIAL", Font.BOLD, 14));
		voltar.setBounds(0,0,100,25);
		voltar.setLocation(50, 130);

		id_cliente.setForeground(new Color(175,87,0));
		id_biscoito.setForeground(new Color(175,87,0));
		quantidade.setForeground(new Color(175,87,0));
		id_embalagem.setForeground(new Color(175,87,0));
		valor_final.setForeground(new Color(175,87,0));

		adicionar.setBackground(new Color(175,87,0));
		adicionar.setForeground(new Color(65,26,13));
		finalizar.setBackground(new Color(175,87,0));
		finalizar.setForeground(new Color(65,26,13));
		voltar.setBackground(new Color(175,87,0));
		voltar.setForeground(new Color(65,26,13));


		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(adicionar);
				remove(finalizar);
				remove(id_cliente);
				remove(id_biscoito);
				remove(quantidade);
                remove(id_embalagem);
				remove(valor_final);
				remove(recebe_id_cliente);
				remove(recebe_id_biscoito);
				remove(recebe_quantidade);
                remove(recebe_id_embalagem);
				remove(recebe_valor_final);
				remove(voltar);
				remove(scroll);

				guarda_id = 0;

				((ControleAux)controle_aux).destroi();
				
				menu(controle, controle_aux);				
			}
		});
    }

    public void menu_inserir_nome(Controle controle, Controle controle_aux){
		setSize(500,500);
		setLayout(null);

		JLabel nome_cliente = new JLabel("CLIENTE: ");
		add(nome_cliente);
		nome_cliente.setBounds(0,0,100,25);
		nome_cliente.setLocation(90, 10);

		JTextField recebe_nome_cliente = new JTextField("");
		recebe_nome_cliente.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_nome_cliente);

		recebe_nome_cliente.setBounds(0,0,250,25);
		recebe_nome_cliente.setLocation(160, 10);


		JLabel nome_biscoito = new JLabel("BISCOITO: ");
		add(nome_biscoito);
		nome_biscoito.setBounds(0,0,100,25);
		nome_biscoito.setLocation(80, 40);

		JTextField recebe_nome_biscoito = new JTextField("");
		recebe_nome_biscoito.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_nome_biscoito);

		recebe_nome_biscoito.setBounds(0,0,250,25);
		recebe_nome_biscoito.setLocation(160, 40);


		JLabel quantidade = new JLabel("QUANTIDADE: ");
		add(quantidade);
		quantidade.setBounds(0,0,100,25);
		quantidade.setLocation(57, 70);

		JTextField recebe_quantidade = new JTextField("");
		recebe_quantidade.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_quantidade);

		recebe_quantidade.setBounds(0,0,250,25);
		recebe_quantidade.setLocation(160, 70);

        JLabel nome_embalagem = new JLabel("EMBALAGEM: ");
		add(nome_embalagem);
		nome_embalagem.setBounds(0,0,100,25);
		nome_embalagem.setLocation(60, 100);

		JTextField recebe_nome_embalagem = new JTextField("");
		recebe_nome_embalagem.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_nome_embalagem);

		recebe_nome_embalagem.setBounds(0,0,250,25);
		recebe_nome_embalagem.setLocation(160, 100);


		JButton adicionar = new JButton("ADICIONAR");
		add(adicionar);
		adicionar.setFont(new Font("ARIAL", Font.BOLD, 14));
		adicionar.setBounds(0,0,120,25);
		adicionar.setLocation(350, 130);

		JLabel valor_final = new JLabel("VALOR FINAL: ");
		add(valor_final);
		valor_final.setBounds(0,0,100,25);
		valor_final.setLocation(57, 420);

		JTextField recebe_valor_final = new JTextField("0,00");
		recebe_valor_final.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_valor_final);
		recebe_valor_final.setBounds(0,0,150,25);
		recebe_valor_final.setLocation(160, 420);

		recebe_valor_final.setEditable(false);


		JTextArea visualizar_venda = new JTextArea(((ControleAux)controle_aux).devolve_string());
		visualizar_venda.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_venda);

		visualizar_venda.setBounds(0,0,450,280);
		visualizar_venda.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_venda);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		//scroll.setViewportView(panelInsNotGrup);
		scroll.setVisible(true);
		scroll.setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25,185, 450,210);
		scroll.getVerticalScrollBar().setValue(0);
		getContentPane().add(scroll);


		JButton finalizar = new JButton("FINALIZAR");
		add(finalizar);
		finalizar.setFont(new Font("ARIAL", Font.BOLD, 14));
		finalizar.setBounds(0,0,120,25);
		finalizar.setLocation(350, 420);
		

		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guarda_nome = recebe_nome_cliente.getText();

				aux.setClienteNome(recebe_nome_cliente.getText());
                aux.setClienteQuantidade(Integer.parseInt(recebe_quantidade.getText()));
                aux.setBiscoitoNome(recebe_nome_biscoito.getText());
                aux.setEmbalagemTipo(recebe_nome_embalagem.getText());
				aux.setEmbalagemCapacidade(1);

				
				recebe_nome_cliente.setText("");
        		recebe_nome_cliente.requestFocus();
				recebe_nome_biscoito.setText("");
        		recebe_nome_biscoito.requestFocus();
				recebe_nome_embalagem.setText("");
        		recebe_nome_embalagem.requestFocus();
				recebe_quantidade.setText("");
        		recebe_quantidade.requestFocus();

				((ControleAux)controle_aux).inserir(aux);

				recebe_valor_final.setText(Float.toString(((ControleAux)controle_aux).soma()));
        		recebe_valor_final.requestFocus();

				visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        		visualizar_venda.requestFocus();
			}
		});

		finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guarda_nome != ""){
					if(((ControleAux)controle_aux).devolve_saldo(0, guarda_nome, 0) > Float.parseFloat(recebe_valor_final.getText())){
						((ControleVenda)controle).inserir(venda);
						((ControleAux)controle_aux).destroi();
						recebe_valor_final.setText("0,00");
						recebe_valor_final.requestFocus();
						visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        				visualizar_venda.requestFocus();
						guarda_nome = "";
					}
					else{
						recebe_valor_final.setText("SALDO INSUFICIENTE");
						recebe_valor_final.requestFocus();
						visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        				visualizar_venda.requestFocus();
					}
				}
				((ControleVenda)controle).inserir(venda);
				((ControleAux)controle_aux).destroi();
				recebe_valor_final.setText("0,00");
        		recebe_valor_final.requestFocus();
				visualizar_venda.setText(((ControleAux)controle_aux).devolve_string());
        		visualizar_venda.requestFocus();
			}
		});
		
		JButton voltar = new JButton("VOLTAR");
		add(voltar);
		voltar.setFont(new Font("ARIAL", Font.BOLD, 14));
		voltar.setBounds(0,0,100,25);
		voltar.setLocation(50, 130);

		nome_cliente.setForeground(new Color(175,87,0));
		nome_biscoito.setForeground(new Color(175,87,0));
		quantidade.setForeground(new Color(175,87,0));
		nome_embalagem.setForeground(new Color(175,87,0));
		valor_final.setForeground(new Color(175,87,0));

		adicionar.setBackground(new Color(175,87,0));
		adicionar.setForeground(new Color(65,26,13));
		finalizar.setBackground(new Color(175,87,0));
		finalizar.setForeground(new Color(65,26,13));
		voltar.setBackground(new Color(175,87,0));
		voltar.setForeground(new Color(65,26,13));

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(adicionar);
				remove(finalizar);
				remove(nome_cliente);
				remove(nome_biscoito);
				remove(quantidade);
                remove(nome_embalagem);
				remove(valor_final);
				remove(recebe_nome_cliente);
				remove(recebe_nome_biscoito);
				remove(recebe_quantidade);
                remove(recebe_nome_embalagem);
				remove(recebe_valor_final);
				remove(scroll);
				remove(voltar);

				guarda_nome = "";

				((ControleAux)controle_aux).destroi();
				
				menu(controle, controle_aux);				
			}
		});
    }


	public void menu_excluir(Controle controle, Controle controle_aux){
		setSize(500,500);
		setLayout(null);

		JLabel cabecario = new JLabel("POR FAVOR FORCEÇA O ID");
		add(cabecario);
		cabecario.setBounds(0,0,350,25);
		cabecario.setLocation(125, 10);


		JLabel id = new JLabel("ID: ");
		add(id);
		id.setBounds(0,0,100,25);
		id.setLocation(95, 40);

		JTextField recebe_id = new JTextField("");
		recebe_id.setFont(new Font("Times", Font.BOLD, 14 ));
		add(recebe_id);
		recebe_id.setBounds(0,0,200,25);
		recebe_id.setLocation(130, 40);



		
		JButton inserir = new JButton("INSERIR");
		add(inserir);
		inserir.setFont(new Font("ARIAL", Font.BOLD, 14));
		inserir.setBounds(0,0,100,25);
		inserir.setLocation(350, 40);



		JTextArea visualizar_venda = new JTextArea(((ControleVenda)controle).devolve_string());
		visualizar_venda.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_venda);

		visualizar_venda.setBounds(0,0,450,280);
		visualizar_venda.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_venda);
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
				((ControleVenda)controle).remover(Integer.parseInt(recebe_id.getText()),null);
				recebe_id.setText("");
        		recebe_id.requestFocus();
				visualizar_venda.setText(((ControleVenda)controle).devolve_string());
				visualizar_venda.requestFocus();
			}
		});
		
		JButton voltar = new JButton("VOLTAR");
		add(voltar);
		voltar.setFont(new Font("ARIAL", Font.BOLD, 14));
		voltar.setBounds(0,0,100,25);
		voltar.setLocation(50, 80);

		cabecario.setForeground(new Color(175,87,0));
		id.setForeground(new Color(175,87,0));

		inserir.setBackground(new Color(175,87,0));
		inserir.setForeground(new Color(65,26,13));
		voltar.setBackground(new Color(175,87,0));
		voltar.setForeground(new Color(65,26,13));

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(cabecario);
				remove(inserir);
				remove(id);
				remove(recebe_id);
				remove(voltar);
				remove(scroll);
				menu(controle, controle_aux);				
			}
		});


		//JTextField tf = new JTextField("Digite aqui");
		//tf.setFont(new Font("Times", Font.BOLD, 28 ));
		//add(tf);
	}


	public void menu_visualizar(Controle controle, Controle controle_aux){
		setSize(500,500);
		setLayout(null);
		JTextArea visualizar_venda = new JTextArea(((ControleVenda)controle).devolve_string());
		visualizar_venda.setFont(new Font("Times", Font.BOLD, 14 ));
		add(visualizar_venda);

		visualizar_venda.setBounds(0,0,450,280);
		visualizar_venda.setEditable(false);
		
		//Painel de notificações    

		JScrollPane scroll = new JScrollPane(visualizar_venda);
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
				menu(controle, controle_aux);				
			}
		});
	}
}

