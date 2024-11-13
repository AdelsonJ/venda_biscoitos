package modelo; 

public abstract class Entidade{
    protected int id; 


    //0 SIGNIFICA QUE É A CLASSE ENTIDADE
    //O CONSTRUTOR QUE RECEBE UM INT SERVIRÁ PARA COLOCAR 
    //OUTROS IDENTIFICADORES PARA AS PROXIMAS CLASSES
    public Entidade(){
        this.id = 0; 
    }

    public Entidade(int id){
        this.id = id; 
    }

    public String toString(){
        String varRetorno = "ID: " + id;
        return varRetorno;
    }
    
    //SO TERÁ O METODO GETTER POIS NAO FARÁ SENTIDO MUDAR 
    //O IDENTIFICADOR DA CLASSE. FOI DEFINIDO AQUI MESMO
    public int getId(){
        return this.id; 
    }

}