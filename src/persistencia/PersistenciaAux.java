package persistencia;

import modelo.*;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PersistenciaAux implements Persistencia {

    private String file1 = "src/arquivo/arquivoBiscoito.json";
    private String file2 = "src/arquivo/arquivoCliente.json";
    private String file3 = "src/arquivo/arquivoEmbalagem.json";
    private String file4 = "src/arquivo/arquivoVenda.json";
    private String file5 = "src/arquivo/arquivoAUX.json";

    private PersistenciaBiscoito pBiscoito = new PersistenciaBiscoito();
    private PersistenciaCliente pCliente = new PersistenciaCliente();
    private PersistenciaEmbalagem pEmbalagem = new PersistenciaEmbalagem();

    public void insere(Entidade entidade){
        /*CLASSES INICIAIS PARA TESTAR FUNCIONALIDADE AO PROGRAMA {BISCOITO, EMBALAGEM E CLIENTE}
        Cliente cliente = new Cliente();
        Biscoito biscoito = new Biscoito();
        Embalagem embalagem = new Embalagem(); */

        String aux1,aux2,aux3,aux4;
        float aux5 = 0;

        //PARA UTILIZAR METODOS ESPECIFICOS DESSAS CLASSES
        

        /*(PersistenciaBiscoito) persistencia pBiscoito = new PersistenciaBiscoito();
        PersistenciaCliente pCliente = new PersistenciaCliente();
        PersistenciaEmbalagem pEmbalagem = new PersistenciaEmbalagem();*/


        //Creating a JSONParser object BISCOITO
        JSONParser jsonParser1 = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader(file1));
            
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
            JSONObject elemento = new JSONObject();
            if(((Aux) entidade).getEmbalagemCapacidade() == -1)
                elemento = (JSONObject) jsonArray.get(pBiscoito.buscaId(Integer.parseInt(((Aux)entidade).getBiscoitoNome())));
            else
                elemento = (JSONObject) jsonArray.get(pBiscoito.buscaString(((Aux)entidade).getBiscoitoNome()));
            
            aux1 = elemento.get("nome").toString();
            aux2 = elemento.get("valor").toString();
            aux3 = elemento.get("quantidadeDisponivel").toString();

            ((Aux)entidade).setBiscoitoNome(aux1);
            ((Aux)entidade).setBiscoitoValor(Float.parseFloat(aux2));
            ((Aux)entidade).setBiscoitoQuantDisponivel(Integer.parseInt(aux3));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Creating a JSONParser object CLIENTE
        JSONParser jsonParser2 = new JSONParser();
        try {

            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser2.parse(new FileReader(file2));
            
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
            JSONObject elemento = new JSONObject();

            if(((Aux)entidade).getEmbalagemCapacidade() == -1)
                elemento = (JSONObject) jsonArray.get(pCliente.buscaId(Integer.parseInt(((Aux)entidade).getClienteNome())));
            else
                elemento = (JSONObject) jsonArray.get(pCliente.buscaString(((Aux)entidade).getClienteNome()));

            aux1 = elemento.get("nome").toString();
            aux2 = elemento.get("saldo").toString();

            ((Aux)entidade).setClienteNome(aux1);
            ((Aux)entidade).setClienteSaldo(Float.parseFloat(aux2));
            ((Aux)entidade).setClienteQuantidade(((Aux)entidade).getClienteQuantidade());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Creating a JSONParser object EMBALAGEM
        JSONParser jsonParser3 = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser3.parse(new FileReader(file3));
            
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("embalagem");
            JSONObject elemento = new JSONObject();

            if(((Aux)entidade).getEmbalagemCapacidade() == -1)
                elemento = (JSONObject) jsonArray.get(pEmbalagem.buscaId(Integer.parseInt(((Aux)entidade).getEmbalagemTipo())));
            else
                elemento = (JSONObject) jsonArray.get(pEmbalagem.buscaString(((Aux)entidade).getEmbalagemTipo()));

            aux1 = elemento.get("tipo").toString();
            aux2 = elemento.get("preco").toString();
            aux3 = elemento.get("quantidadeDisponivel").toString();
            aux4 = elemento.get("capacidade").toString();

            ((Aux)entidade).setEmbalagemTipo(aux1);
            ((Aux)entidade).setEmbalagemPreco(Float.parseFloat(aux2));
            ((Aux)entidade).setEmbalagemQuantidadeDisponivel(Integer.parseInt(aux3));
            ((Aux)entidade).setEmbalagemCapacidade(Integer.parseInt(aux4));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //GUARDA NUM OBJETO PARA DEPOIS SER INSERIDO NO ARRAY
        JSONObject teste = new JSONObject();
        teste.put("nome biscoito",((Aux)entidade).getBiscoitoNome());
        teste.put("valor biscoito",((Aux)entidade).getBiscoitoValor());
        teste.put("quantidade biscoito",((Aux)entidade).getBiscoitoQuantDisponivel());
        teste.put("nome cliente",((Aux)entidade).getClienteNome());
        teste.put("saldo cliente",((Aux)entidade).getClienteSaldo());
        teste.put("quantidade cliente",((Aux)entidade).getClienteQuantidade());
        teste.put("nome embalagem",((Aux)entidade).getEmbalagemTipo());
        teste.put("preco embalagem",((Aux)entidade).getEmbalagemPreco());
        teste.put("quantidade embalagem",((Aux)entidade).getEmbalagemQuantidadeDisponivel());
        teste.put("capacidade embalagem",((Aux)entidade).getEmbalagemCapacidade());


        //CONFERE SE A QUANTIDADE QUE O CLIENTE DIGITOU EH 0
        if(((Aux)entidade).getClienteQuantidade() == 0)
            //CANCELA A COMPRA SE A QUANTIDADE QUE O USUARIO QUE FOR IGUAL A 0
            aux5 = 0;
        else{
            //CONTINUA SE  A QUANTIDADE DIFERENTE DE 0
            ((Aux)entidade).Atualiza();
            aux5 = ((Aux)entidade).calcularCompra();
        }

        //GUARDA E ATUALIZA OS VALORES DA VENDA
        if(aux5 > 0){;
            teste.put("valor final", aux5);


            /*pBiscoito.altera(cliente, biscoito, embalagem,venda);
            pCliente.altera(cliente, biscoito, embalagem,venda);
            pEmbalagem.altera(cliente, biscoito, embalagem,venda);*/

            //CRIANDO UM OBJETO JSONPARSER
            JSONParser jsonParser = new JSONParser();
            try {
                //Parsing the contents of the JSON file
                //PARSENADO O CONTEÚDO DO ARQUIVO DA MEMÓRIA PARA UM OBJETO JSON 

                Path path = Paths.get(file5);
                boolean notExists = Files.notExists(path);

                if(notExists){
                    try{
                        BufferedWriter bw = new BufferedWriter(
                            new FileWriter(file5));    
                        bw.write("{\"auxiliar\": []}"); 
                        bw.close();
                    }
                    catch(Exception ex){
                        return; 
                    }
                }

                teste.put("id", this.percorrerArray() + 1);

                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
                
                //RECUPERANDO O ARRAY
                JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");
                jsonArray.add(teste);

                JSONObject guarda = new JSONObject();
                guarda.put("auxiliar",jsonArray);

                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file5));    
                    bw.write(guarda.toString()); 
                    bw.close();
                }
                catch(Exception ex){
                    return; 
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }
    
    

    public void altera(Entidade entidade){
        
    }


    public void exclui(int id, String nome){

    }


    public int buscaId(int id){
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux = elemento.get("id").toString();
                if(id == Integer.parseInt(aux)){
                    return i;
                }
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("NÃO FOI ENCONTRADO");
        return -1;
    }

    public int buscaString(String string){
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux = elemento.get("valor final").toString();
                if(aux.equals(string)){
                    return i;
                }
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int percorrerArray(){
        int maior = 0;
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux = elemento.get("id").toString();
                if(Integer.parseInt(aux) > maior)
                    maior = Integer.parseInt(aux);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return maior;
    }

    public float soma(){
        float soma = 0;
        String aux;
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux = elemento.get("valor final").toString();
                soma =  soma + Float.parseFloat(aux);
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return soma;
    }


    public void destroi(){
        int aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");

            for (int i=0; i < jsonArray.size() ; ){

                jsonArray.remove(jsonArray.get(i));
            }

            JSONObject guarda = new JSONObject();
            guarda.put("auxiliar",jsonArray);

            try{
                BufferedWriter bw = new BufferedWriter(
                    new FileWriter(file5));   
                    bw.write(guarda.toString()); 
                    bw.close();
                }
            catch(Exception ex){
            return; 
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public float devolve_saldo(int id, String nome,int decide){
        String aux = "0,00";

        //Creating a JSONParser object CLIENTE
        JSONParser jsonParser2 = new JSONParser();
        try {

            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser2.parse(new FileReader(file2));
            
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
            JSONObject elemento = new JSONObject();

            if(decide == -1)
                elemento = (JSONObject) jsonArray.get(pCliente.buscaId(id));
            else
                elemento = (JSONObject) jsonArray.get(pCliente.buscaString(nome));

            
            aux = elemento.get("saldo").toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Float.parseFloat(aux);
    }

    public String devolve_string(){
        String aux = "";
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            Path path = Paths.get(file5);
            boolean notExists = Files.notExists(path);
            if(notExists){
                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file5));    
                    bw.write("{\"auxiliar\": []}"); 
                    bw.close();
                }
                catch(Exception ex){
                    return "DEU ERRADO"; 
                }
            }
            
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux += ("ID: " + elemento.get("id") +
                        "\nNome do Biscoito: " + elemento.get("nome biscoito") +
                        "\nValor do Biscoito: " + elemento.get("valor biscoito") +
                        "\nQuantidade de Biscoito: " + elemento.get("quantidade biscoito") +
                        "\nNome du Cliente: " + elemento.get("nome cliente") +
                        "\nSaldo du Cliente: " + elemento.get("saldo cliente") +
                        "\nQuantidade du Cliente: " + elemento.get("quantidade cliente") +
                        "\nNome da Embalagem: " + elemento.get("nome embalagem") +
                        "\nValor da Embalagem: " + elemento.get("preco embalagem") +
                        "\nQuantidade da Embalagem: " + elemento.get("quantidade embalagem") +
                        "\nCapacidade da Embalagem: " + elemento.get("capacidade embalagem") +
                        "\nValor Final: " + elemento.get("valor final").toString() +
                        "\n\n---------------------------------------------------------------------------\n\n");
            }

        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return aux;
    }
}