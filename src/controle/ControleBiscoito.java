package controle;

import persistencia.PersistenciaBiscoito;

public class ControleBiscoito extends Controle {
    
    public ControleBiscoito() {
        super(new PersistenciaBiscoito());
    }
}
