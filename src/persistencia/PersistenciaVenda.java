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



public class PersistenciaVenda implements Persistencia {

    private String file1 = "src/arquivo/arquivoBiscoito.json";
    private String file2 = "src/arquivo/arquivoCliente.json";
    private String file3 = "src/arquivo/arquivoEmbalagem.json";
    private String file4 = "src/arquivo/arquivoVenda.json";
    private String file5 = "src/arquivo/arquivoAUX.json";

    public void insere(Entidade entidade){
        /*CLASSES INICIAIS PARA TESTAR FUNCIONALIDADE AO PROGRAMA {BISCOITO, EMBALAGEM E CLIENTE}
        Cliente cliente = new Cliente();
        Biscoito biscoito = new Biscoito();
        Embalagem embalagem = new Embalagem(); */

        String aux1,aux2,aux3,aux4;
        float aux5 = 0;

        //PARA UTILIZAR METODOS ESPECIFICOS DESSAS CLASSES
        PersistenciaBiscoito pBiscoito = new PersistenciaBiscoito();
        PersistenciaCliente pCliente = new PersistenciaCliente();
        PersistenciaEmbalagem pEmbalagem = new PersistenciaEmbalagem();
        PersistenciaAux pAux = new PersistenciaAux();


        JSONParser jsonParser = new JSONParser();
        try {  
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file5));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("auxiliar");

            JSONObject teste = new JSONObject();
            JSONParser jsonParser_venda = new JSONParser();

            int armazena_biscoito = 0;
            Float armazena_cliente = 0f;
            int armazena_embalagem = 0;
            int aux6 = 0;

            for (int i=0; i < jsonArray.size() ; i++){

                JSONObject elemento = (JSONObject) jsonArray.get(i);

                teste.put("nome biscoito", elemento.get("nome biscoito"));
                teste.put("valor biscoito", elemento.get("valor biscoito"));
                teste.put("quantidade biscoito", elemento.get("quantidade biscoito"));
                teste.put("nome cliente", elemento.get("nome cliente"));
                teste.put("saldo cliente", elemento.get("saldo cliente"));
                teste.put("quantidade cliente", elemento.get("quantidade cliente"));
                teste.put("nome embalagem", elemento.get("nome embalagem"));
                teste.put("preco embalagem", elemento.get("preco embalagem"));
                teste.put("quantidade embalagem", elemento.get("quantidade embalagem"));
                teste.put("capacidade embalagem", elemento.get("capacidade embalagem"));
                teste.put("valor final", elemento.get("valor final"));

                ((Venda)entidade).setBiscoitoNome(elemento.get("nome biscoito").toString());
                ((Venda)entidade).setBiscoitoValor(Float.parseFloat(elemento.get("valor biscoito").toString()));
                ((Venda)entidade).setBiscoitoQuantDisponivel(Integer.parseInt(elemento.get("quantidade biscoito").toString()) - armazena_biscoito);

                ((Venda)entidade).setClienteNome(elemento.get("nome cliente").toString());
                ((Venda)entidade).setClienteQuantidade(Integer.parseInt(elemento.get("quantidade cliente").toString()));
                ((Venda)entidade).setClienteSaldo(Float.parseFloat(elemento.get("saldo cliente").toString()) - armazena_cliente);

                ((Venda)entidade).setEmbalagemTipo(elemento.get("nome embalagem").toString());
                ((Venda)entidade).setEmbalagemPreco(Float.parseFloat(elemento.get("preco embalagem").toString()));
                ((Venda)entidade).setEmbalagemQuantidadeDisponivel(Integer.parseInt(elemento.get("quantidade embalagem").toString()) - armazena_embalagem);
                ((Venda)entidade).setEmbalagemCapacidade(Integer.parseInt(elemento.get("capacidade embalagem").toString()));
                
                armazena_biscoito = armazena_biscoito + Integer.parseInt(elemento.get("quantidade cliente").toString());
                armazena_cliente = armazena_cliente + Float.parseFloat(elemento.get("valor final").toString());


                //venda.calcularCompra();
                ((Venda)entidade).Atualiza();
                ((Venda)entidade).calcularCompra();
                aux6 = ((Venda)entidade).DemandaCaixa(Integer.parseInt(elemento.get("quantidade cliente").toString()));

                armazena_embalagem = armazena_embalagem + aux6;

                pBiscoito.altera(entidade);
                pCliente.altera(entidade);
                pEmbalagem.altera(entidade);

                //GUARDA E ATUALIZA OS VALORES DA VENDA
                
                /*pBiscoito.altera(cliente, biscoito, embalagem,venda);
                pCliente.altera(cliente, biscoito, embalagem,venda);
                pEmbalagem.altera(cliente, biscoito, embalagem,venda);*/

                //CRIANDO UM OBJETO JSONPARSER
                try {
                    //Parsing the contents of the JSON file
                    //PARSENADO O CONTEÚDO DO ARQUIVO DA MEMÓRIA PARA UM OBJETO JSON 
                
                    Path path = Paths.get(file4);
                    boolean notExists = Files.notExists(path);

                    if(notExists){
                        try{
                            BufferedWriter bw = new BufferedWriter(
                            new FileWriter(file4));    
                            bw.write("{\"venda\": []}"); 
                            bw.close();
                        }
                        catch(Exception ex){
                            return; 
                        }
                    }

                    teste.put("id", this.percorrerArray() + 1);

                    JSONObject jsonObject_venda = (JSONObject) jsonParser_venda.parse(new FileReader(file4));
                        
                    //RECUPERANDO O ARRAY
                    JSONArray jsonArray_venda = (JSONArray) jsonObject_venda.get("venda");
                    jsonArray_venda.add(teste);

                    JSONObject guarda = new JSONObject();
                    guarda.put("venda",jsonArray_venda);

                    try{
                        BufferedWriter bw = new BufferedWriter(
                            new FileWriter(file4));    
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    
    

    public void altera(Entidade entidade){
        
    }


    public void exclui(int id, String nome){
        if(id > 0){
            //Creating a JSONParser object
            JSONParser jsonParser1 = new JSONParser();
            try {
                //Parsing the contents of the JSON file
                JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader(file4));
                            
                //Retrieving the array
                JSONArray jsonArray = (JSONArray) jsonObject.get("venda");
                jsonArray.remove(jsonArray.get(buscaId(id)));

                JSONObject guarda = new JSONObject();
                guarda.put("venda",jsonArray);

                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file4));   
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
        else{
            //Creating a JSONParser object
            JSONParser jsonParser2 = new JSONParser();
            try {
                //Parsing the contents of the JSON file
                JSONObject jsonObject = (JSONObject) jsonParser2.parse(new FileReader(file4));
                        
                //Retrieving the array
                JSONArray jsonArray = (JSONArray) jsonObject.get("venda");
                jsonArray.remove(jsonArray.get(buscaString(nome)));

                JSONObject guarda = new JSONObject();
                guarda.put("venda",jsonArray);

                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file4));   
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


    public int buscaId(int id){
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file4));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("venda");
            
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
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file4));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("venda");
            
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


    public String devolve_string(){
        String aux = "";
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            Path path = Paths.get(file4);
            boolean notExists = Files.notExists(path);
            if(notExists){
                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file4));    
                    bw.write("{\"venda\": []}"); 
                    bw.close();
                }
                catch(Exception ex){
                    return "DEU ERRADO"; 
                }
            }
            
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file4));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("venda");
            
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

    public int percorrerArray(){
        int maior = 0;
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file4));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("venda");
            
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

    public float devolve_saldo(int id, String nome,int decide){
        return 0f;
    }
  
    public void destroi(){
        
    }
  
    public float soma(){
        return 0f;
    }
}