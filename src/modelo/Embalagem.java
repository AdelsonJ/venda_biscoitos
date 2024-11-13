package modelo;

public class Embalagem extends Entidade{
    protected String tipo;
    protected float preco;
    protected int quantidadeDisponivel;
    protected int capacidade;

    //CONSTRUTORES, ONDE ID 3 REPRESENTA ESSA CLASSE
    public Embalagem(){
        super(3);
        this.tipo = null;
        this.preco = 0f;
        this.quantidadeDisponivel = 0;
        this. capacidade = 0;
    }
    public Embalagem(String tipo, float preco, int quantidadeDisponivel, int capacidade){
        super(3);
        this.tipo = tipo;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this. capacidade = capacidade;
    }


    //METODO GETTER
    public String getTipo(){
        return this.tipo;
    }
    public float getPreco(){
        return this.preco;
    }
    public int getQuantidadeDisponivel(){
        return this.quantidadeDisponivel;
    }
    public int getCapacidade(){
        return this.capacidade;
    }


    //METODO SETTER
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }
    public void setQuantidadeDisponivel(int quantidadeDisponivel){
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }

    


    //OVERRIDE DO METODO ABSTRATO DA CLASSE ENTIDADE
    @Override
    public String toString(){
        return super.toString() + "Tipo: " + this.tipo + "\nPreco: " + this.preco + "\nquantidadeDisponivel: " + this.quantidadeDisponivel + "\nCapacidade: " + this.capacidade; 
    } 

}