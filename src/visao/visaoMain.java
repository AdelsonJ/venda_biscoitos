package visao;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

import controle.*;

public class visaoMain extends JFrame {

	private ControleBiscoito cBiscoito;
	private ControleCliente cCliente;
	private ControleEmbalagem cEmbalagem;
	private ControleVenda cVenda;
	private ControleAux cAux;
	
	private static visaoMain uniqueInstance;

	public visaoMain( ){
		setSize(400, 325);
		setTitle("BITSCOITO");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

		getContentPane().setBackground(new Color(65,26,13));
		
		setLayout(new FlowLayout());

        //menu();
    }

	public static visaoMain getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new visaoMain();
		return uniqueInstance;
	}
	 
	public void menu(){
		setVisible(true);
		//CRIACAO DA PRIMEIRA ESCOLHA

		//ImageIcon imageBotao = new ImageIcon(getClass().getResource(imagem_cookie));
		//ImageIcon imageBotao = new ImageIcon(imagem_cookie);


		this.cBiscoito = new ControleBiscoito();
		this.cCliente = new ControleCliente();
		this.cEmbalagem = new ControleEmbalagem();
		this.cVenda = new ControleVenda();
		this.cAux = new ControleAux();
		
		
        JButton bt_biscoito = new JButton("BISCOITO");
		add(bt_biscoito);
        bt_biscoito.setPreferredSize(new Dimension(250,50));
		bt_biscoito.setFont(new Font("ARIAL", Font.BOLD, 25));

        JButton bt_cliente = new JButton("CLIENTE");
		add(bt_cliente);
        bt_cliente.setPreferredSize(new Dimension(250,50));
		bt_cliente.setFont(new Font("ARIAL", Font.BOLD, 25));

        JButton bt_embalagem = new JButton("EMBALAGEM");
		add(bt_embalagem);
        bt_embalagem.setPreferredSize(new Dimension(250,50));
		bt_embalagem.setFont(new Font("ARIAL", Font.BOLD, 25));
        
		JButton bt_venda = new JButton("VENDA");
		add(bt_venda);
        bt_venda.setPreferredSize(new Dimension(250,50));
		bt_venda.setFont(new Font("ARIAL", Font.BOLD, 25));
        
        JButton bt_voltar = new JButton("SAIR");
		add(bt_voltar);
        bt_voltar.setPreferredSize(new Dimension(250,50));
		bt_voltar.setFont(new Font("ARIAL", Font.BOLD, 25));


		bt_biscoito.setBackground(new Color(175,87,0));
		bt_biscoito.setForeground(new Color(65,26,13));
		bt_cliente.setBackground(new Color(175,87,0));
		bt_cliente.setForeground(new Color(65,26,13));
		bt_embalagem.setBackground(new Color(175,87,0));
		bt_embalagem.setForeground(new Color(65,26,13));
		bt_venda.setBackground(new Color(175,87,0));
		bt_venda.setForeground(new Color(65,26,13));
		bt_voltar.setBackground(new Color(175,87,0));
		bt_voltar.setForeground(new Color(65,26,13));

		

		//CRIACAO DA ESCOLHA A PARTIR DO BISCOITO	
		bt_biscoito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_biscoito);
				remove(bt_cliente);
				remove(bt_embalagem);
				remove(bt_venda);
				remove(bt_voltar);

				//visaoBiscoito vBiscoito= new visaoBiscoito(cBiscoito);

				visaoBiscoito.getInstance().menu(cBiscoito);;
				
				setVisible(false);
			}
		});

		//CRIACAO DA ESCOLHA A PARTIR DO CLIENTE	
		bt_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_biscoito);
				remove(bt_cliente);
				remove(bt_embalagem);
				remove(bt_venda);
				remove(bt_voltar);

				visaoCliente.getInstance().menu(cCliente);

				setVisible(false);
			}
		});

		//CRIACAO DA ESCOLHA A PARTIR DA EMBALAGEM	
		bt_embalagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_biscoito);
				remove(bt_cliente);
				remove(bt_embalagem);
				remove(bt_venda);
				remove(bt_voltar);

				visaoEmbalagem.getInstance().menu(cEmbalagem);
				setVisible(false);
			}
		});

		//CRIACAO DA ESCOLHA A PARTIR DA VENDA
		bt_venda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_biscoito);
				remove(bt_cliente);
				remove(bt_embalagem);
				remove(bt_venda);
				remove(bt_voltar);

				visaoVenda.getInstance().menu(cVenda, cAux);

				setVisible(false);

				//menu_venda();
			}
		});

		//CRIACAO DA ESCOLHA PRA ENCERRAR	
		bt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//REMOVE O LAYOUT ANTERIOR
				remove(bt_biscoito);
				remove(bt_cliente);
				remove(bt_embalagem);
				remove(bt_venda);
				remove(bt_voltar);

				dispose();
			}
		});
    }

	
}
