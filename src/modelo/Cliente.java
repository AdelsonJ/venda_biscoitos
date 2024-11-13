package modelo;

public class Cliente extends Entidade{
    protected String nome;
    protected float saldo; 
    protected int quantidade;

    //ESSA CLASSE TEM O IDENTIFICADOR 5. SEGUE OS CONSTRUTORES
    public Cliente(){
        super(5); 
        this.nome = null;
        this.saldo = 0.0f; 
        this.quantidade = 0;
    }
    public Cliente(String nome, float saldo, int quantidade){
        super(5); 
        this.nome = nome;
        this.saldo = saldo; 
        this.quantidade = quantidade;
    }

    //METODO GETTERS
    public String getNome(){
        return this.nome; 
    }
    public float getSaldo(){
        return this.saldo; 
    }
    public int getQuantidade(){
        return this.quantidade;
    }

    //METODO SETTERS
    public void setNome(String nome){
        this.nome = nome; 
    }
    public void setSaldo(float saldo){
        this.saldo = saldo; 
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade; 
    }

    //OVERRIDE DO METODO ABSTRATO RETORNO
    public String toString(){
        return super.toString() + "Nome: " + this.nome + "\nSaldo: "+this.saldo; 
    } 



}
