package controle;

import persistencia.PersistenciaVenda;

public class ControleVenda extends Controle{
    public ControleVenda() {
        super(new PersistenciaVenda());
    }
}
