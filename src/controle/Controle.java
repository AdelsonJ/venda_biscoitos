package controle;

import persistencia.*;
import modelo.*;

public abstract class Controle {
  
    protected Persistencia persistencia;

    public Controle(Persistencia persistencia) {
      this.persistencia = persistencia;
    }
  
    public void inserir(Entidade entidade) {
      persistencia.insere(entidade);
    }
  
    public void remover(int id, String nome) {
      persistencia.exclui(id, nome);
    }
  
    public void alterar(Entidade entidade) {
      persistencia.altera(entidade);
    }
  
    public int buscaId(int id) {
      return persistencia.buscaId(id);
    }
  
    public int buscaString(String string) {
      return persistencia.buscaString(string);
    }
    
    public int percorrerArray(){
      return persistencia.percorrerArray();
    }
  
    
    public String devolve_string(){
      return persistencia.devolve_string();
    }

    public float devolve_saldo(int id, String nome,int decide){
      return persistencia.devolve_saldo(id, nome, decide);
    }

    public void destroi(){
      persistencia.destroi();
    }

    public float soma(){
      return persistencia.soma();
    }
  }
