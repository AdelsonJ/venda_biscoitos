package controle;

import persistencia.PersistenciaAux;


public class ControleAux extends Controle{
    public ControleAux() {
        super(new PersistenciaAux());
    }
}
