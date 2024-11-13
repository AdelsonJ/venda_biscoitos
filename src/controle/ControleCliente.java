package controle;

import persistencia.PersistenciaCliente;

public class ControleCliente extends Controle {
    public ControleCliente() {
        super(new PersistenciaCliente());
    }
}
