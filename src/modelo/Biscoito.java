package modelo;

public class Biscoito extends Entidade {
    protected String nome; 
    protected float valor; 
    protected int quantidadeDisponivel; 


    //CONSTRUTOR COM OS PARAMETROS
    //O ID SIGNIFICA UMA CLASSE BISCOITO
    public Biscoito(){
        super(1); 
        this.nome = null; 
        this.valor = 0f; 
        this.quantidadeDisponivel = 0;
    }
    public Biscoito(String nome, float valor, int quantidadeDisponivel){
        super(1); 
        this.nome = nome; 
        this.valor = valor; 
        this.quantidadeDisponivel = quantidadeDisponivel;
    }


    //METODOS GETTERS 
    public String getNome(){
        return this.nome; 
    }
    public float getValor(){
        return this.valor; 
    }
    public int getQuantDisponivel(){
        return this.quantidadeDisponivel; 
    }
    //METODOS SETTERS
    public void setNome(String nome){
        this.nome = nome; 
    }
    public void setValor(float valor){
        this.valor = valor; 
    }
    public void setQuantDisponivel(int quantidadeDisponivel){
        this.quantidadeDisponivel = quantidadeDisponivel; 
    }

    //OVERRIDE DO METODO QUE RETORNA OS ATRIBUTOS E OS VALORES
    @Override
    public String toString(){
        //System.out.printf("Esse objeto (Biscoito) contém os seguintes atributos: \n"); 
        //System.out.printf("Nome: %s\nValor: %f\n Quant. Disponivel: %d", this.nome, this.valor, this.quantidadeDisponivel); 
        return super.toString() + "Nome: "+this.nome+"\n"+ "Valor: "+this.valor+"\n"+"Quant. Disponivel: "+this.quantidadeDisponivel; 
    } 

}
