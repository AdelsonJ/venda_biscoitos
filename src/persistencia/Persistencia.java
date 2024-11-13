package persistencia;

import modelo.*;

public interface Persistencia {
    //ESSA INTERFACE SERÁ IMPLEMENTADA POR EQUIVALENTES 
    //ÀS CLASSES DO MODELO (BISCOITO, EMBALAGEM, VENDA E CLIENTE)

    public abstract void insere(Entidade entidade);
    public abstract void altera(Entidade entidade);
    public abstract void exclui(int id, String nome);
    public abstract int buscaId(int id);
    public abstract int buscaString(String string);
    public abstract int percorrerArray();
    public abstract String devolve_string();
    
    public abstract float devolve_saldo(int id, String nome,int decide);
    public abstract void destroi();
    public abstract float soma();
}
