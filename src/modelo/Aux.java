package modelo;

public class Aux extends Entidade {
    Cliente cliente = new Cliente();
    Biscoito biscoito = new Biscoito();
    Embalagem embalagem = new Embalagem();

    //CONSTRUTOR COM OS PARAMETROS
    //CLASSE TEM O IDENTIFICADOR ID 4
    public Aux(){
        super(2); 
        this.biscoito.nome = null;
        this.biscoito.valor = 0;
        this.biscoito.quantidadeDisponivel = 0;
        this.embalagem.tipo = null;
        this.embalagem.preco = 0;
        this.embalagem.quantidadeDisponivel = 0;
        this.embalagem.capacidade = 0;
        this.cliente.nome = null;
        this.cliente.quantidade = 0;
        this.cliente.saldo = 0;
    }

    public Aux(Biscoito biscoito, Embalagem embalagem, Cliente cliente){
        super(2); 
        this.biscoito.nome = biscoito.getNome();
        this.biscoito.valor = biscoito.getValor();
        this.biscoito.quantidadeDisponivel = biscoito.getQuantDisponivel();
        this.embalagem.tipo = embalagem.getTipo();
        this.embalagem.preco = embalagem.getPreco();
        this.embalagem.quantidadeDisponivel = embalagem.getQuantidadeDisponivel();
        this.embalagem.capacidade = embalagem.getCapacidade();
        this.cliente.nome = cliente.getNome();
        this.cliente.quantidade = cliente.getQuantidade();
        this.cliente.saldo = cliente.getSaldo();
    }

    //METODOS GETTERS 
    public String getBiscoitoNome(){
        return this.biscoito.nome; 
    }
    public float getBiscoitoValor(){
        return this.biscoito.valor; 
    }
    public int getBiscoitoQuantDisponivel(){
        return this.biscoito.quantidadeDisponivel; 
    }
    public String getEmbalagemTipo(){
        return this.embalagem.tipo;
    }
    public float getEmbalagemPreco(){
        return this.embalagem.preco;
    }
    public int getEmbalagemQuantidadeDisponivel(){
        return this.embalagem.quantidadeDisponivel;
    }
    public int getEmbalagemCapacidade(){
        return this.embalagem.capacidade;
    }
    public String getClienteNome(){
        return this.cliente.nome; 
    }
    public float getClienteSaldo(){
        return this.cliente.saldo; 
    }
    public int getClienteQuantidade(){
        return this.cliente.quantidade;
    }

    //METODOS SETTERS
    public void setBiscoitoNome(String nome){
        this.biscoito.nome = nome; 
    }
    public void setBiscoitoValor(float valor){
        this.biscoito.valor = valor; 
    }
    public void setBiscoitoQuantDisponivel(int quantidadeDisponivel){
        this.biscoito.quantidadeDisponivel = quantidadeDisponivel; 
    }
    public void setEmbalagemTipo(String tipo){
        this.embalagem.tipo = tipo;
    }
    public void setEmbalagemPreco(float preco){
        this.embalagem.preco = preco;
    }
    public void setEmbalagemQuantidadeDisponivel(int quantidadeDisponivel){
        this.embalagem.quantidadeDisponivel = quantidadeDisponivel;
    }
    public void setEmbalagemCapacidade(int capacidade){
        this.embalagem.capacidade = capacidade;
    }
    public void setClienteNome(String nome){
        this.cliente.nome = nome; 
    }
    public void setClienteSaldo(float saldo){
        this.cliente.saldo = saldo; 
    }
    public void setClienteQuantidade(int quantidade){
        this.cliente.quantidade = quantidade; 
    }

    

    //FUNCAO QUE CALCULA A DEMANDA DE UMA DETERMINADA CAIXA PARA CABER OS BISCOITOS
    public int DemandaCaixa(int quantidade){
        int cabe = 0;       //VARIAVEL QUE GUARDA O NOVO VALOR DA CAPACIDADE TOTAL
        int demanda = 0;    //VARIAVEL QUE CONTA QUANTAS CAIXAS FORAM NECESSARIAS PARA SUPORTAR OS BISCOITOS
        //A MEDIDA QUE O NUMERO DE CAIXAS AUMENTAM, A CAPACIDADE AUMENTA; EH NECESSARIO FAZER ATE QUE 
        //TODOS OS BISCOITOS POSSAM SER ARMAZENADOS COM SUCESSO
        if(quantidade == 0)
            return 0;
        else{
            do{
                demanda++;
                cabe = cabe + this.embalagem.capacidade;
            }while(cabe < quantidade);
            return demanda;
        }
    }


    //FUNCAO PARA CONFERIR SE A QUANTIDADE DE BISCOITOS SOLICITADA ESTA DISPONIVEL, CASO NAO RECEBE NOVO VALOR PARA ESSA QUANTIDADE
    public int podeBiscoito(){
        if(this.cliente.getQuantidade() > this.biscoito.getQuantDisponivel()){
            return 1;
        }
        return 0;
    }


    //FUNCAO QUE SETA O VALOR DA QUANTIDADE CASO NAO HAJA EMBALAGENS O SUFICIENTE
    public int devolveQuantidadeEmbalagem(){
        int aux = DemandaCaixa(this.cliente.getQuantidade());
        //NESSE CASO, O USUARIO OPTOU POR COMPRAR AS EMBALAGENS DISPONIVEIS E SUA A QUANTIDADE
        //QUE ELE QUERIA PASSOU A SER A DISPONIVEL QUE A EMBALAGEM PODE ARMAZENAR
        if(embalagem.getQuantidadeDisponivel() < aux){
            return 1;
        }
        return 0;
    }


    //FUNCAO PARA CALCULAR O VALOR DA COMPRA DOS BISCOITOS
    public float calcularCompra(){
        podeBiscoito();
        return ((this.biscoito.getValor()* this.cliente.getQuantidade()) + (DemandaCaixa(this.cliente.getQuantidade()) * this.embalagem.getPreco())); 
    }


    //APOS O CALCULO DA COMPRA, DEVE-SE ATUALIZAR AS QUANTIDADES E O SALDO DO CLIENTE
    public void Atualiza(){
        //CASO O SALDO DO CLIENTE SEJA MENOR QUE O VALOR DA SUA COMPRA, OS VALORES
        //PERMANECEM OS MESMOS E A COMPRA EH CANCELADA
        if(this.cliente.getSaldo() >= calcularCompra()){
            this.cliente.setSaldo(cliente.getSaldo() - calcularCompra());
            this.embalagem.setQuantidadeDisponivel(this.embalagem.getQuantidadeDisponivel() - DemandaCaixa(this.cliente.getQuantidade()));
            this.biscoito.setQuantDisponivel(this.biscoito.getQuantDisponivel() - this.cliente.getQuantidade());
            //System.out.print("COMPRA REALIZADA COM SUCESSO!\n");
        }
        else
            System.out.print("SALDO INSUFICIENTE!!\nCOMPRA CANCELADA!!\n!");
    }

    

    //OVERRIDE DO METODO ABSTRATO DA CLASSE ENTIDADE
    @Override
    public String toString(){
        return super.toString() + "Id é o unico atributo.\nId: "+this.id; 
    } 

    //METODO GETTER DESSA CLASE, NA VERDADE, ACABA SENDO
    //O METODO GETTER DA CLASSE ENTIDADE
    public int getVenda(){
        return this.getId(); 
    }
    

}
