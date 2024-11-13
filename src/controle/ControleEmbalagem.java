package controle;

import persistencia.PersistenciaEmbalagem;

public class ControleEmbalagem extends Controle{
    public ControleEmbalagem() {
        super(new PersistenciaEmbalagem());
    }
}
