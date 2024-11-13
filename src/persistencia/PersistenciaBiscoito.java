package persistencia;

//IMPORTS DE BIBLIOTECAS


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

//IMPORTS DO CODIGO LOCAL
import modelo.*;


//const string path = "/teste/"

public class PersistenciaBiscoito implements Persistencia {

    private String file = "src/arquivo/arquivoBiscoito.json";

    /*----METODO INSERE-----
    OVERRIDE DO METODO ABSTRATO DA INTERFACE
    ESSE ARQUIVO JOGA UM OBJETO DO PROGRAMA PARA UM ARQUIVO
    EM FORMADO JSON */ 

    public void insere(Entidade entidade){

        //CRIANDO UM OBJETO DO TIPO JSON PARA JOGAR OS DADOS
        //NA MEMÓRIA (EM EXTENSÃO .json)
        JSONObject insere = new JSONObject();
        insere.put("nome",((Biscoito)entidade).getNome());
        insere.put("valor",((Biscoito)entidade).getValor());
        insere.put("quantidadeDisponivel", ((Biscoito)entidade).getQuantDisponivel());

        
        //CRIANDO UM OBJETO JSONPARSER
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            //PARSENADO O CONTEÚDO DO ARQUIVO DA MEMÓRIA PARA UM OBJETO JSON 

            //RECUPERANDO O ARRAY

            Path path = Paths.get(file);
            boolean notExists = Files.notExists(path);

            if(notExists){
                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file));    
                    bw.write("{\"biscoito\": []}"); 
                    bw.close();
                }
                catch(Exception ex){
                    return; 
                }
            }

            insere.put("id", this.percorrerArray() + 1);

            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
            jsonArray.add(insere);
            JSONObject guarda = new JSONObject();
            guarda.put("biscoito",jsonArray);

            try{
                BufferedWriter bw = new BufferedWriter(
                    new FileWriter(file)); 
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
    
    /*METODO ALTERA
    *OVERRIDE
    *ESSE METODO SERVE PARA PUXAR UM JSON DA MEMORIA, ALTERAR UM CONTEUDO
    *E ENTÃO SALVAR NOVAMENTE */ 
    public void altera(Entidade entidade){
        //String aux1,aux2,aux3;

        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");

            JSONObject elemento = (JSONObject) jsonArray.get(buscaString(((Venda)entidade).getBiscoitoNome()));

            JSONObject objAltera= new JSONObject();
            objAltera.put("id", elemento.get("id"));
            objAltera.put("nome", elemento.get("nome").toString());
            objAltera.put("valor", elemento.get("valor"));
            objAltera.put("quantidadeDisponivel", ((Venda)entidade).getBiscoitoQuantDisponivel());

            
            jsonArray.remove(jsonArray.get(buscaString(((Venda)entidade).getBiscoitoNome())));
            jsonArray.add(objAltera);

            JSONObject guarda = new JSONObject();
            guarda.put("biscoito",jsonArray);

            try{
                BufferedWriter bw = new BufferedWriter(
                    new FileWriter(file));    
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



    /* ---METODO PARA EXCLUIR UMA INFORMAÇÃO DO ARQUIVO JSON 
    OVERRIDE DO METODO ABSTRATO*/ 
    
    public void exclui(int id, String nome){
        if(id > 0){
            //Creating a JSONParser object
            JSONParser jsonParser1 = new JSONParser();
            try {
                //Parsing the contents of the JSON file
                JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader(file));
                            
                //Retrieving the array
                JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
                jsonArray.remove(jsonArray.get(buscaId(id)));

                JSONObject guarda = new JSONObject();
                guarda.put("biscoito",jsonArray);

                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file));   
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
                JSONObject jsonObject = (JSONObject) jsonParser2.parse(new FileReader(file));
                        
                //Retrieving the array
                JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
                jsonArray.remove(jsonArray.get(buscaString(nome)));

                JSONObject guarda = new JSONObject();
                guarda.put("biscoito",jsonArray);

                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file));   
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




//ESSA FUNÇÃO SERVE PARA BUSCAR O OBJETO SALVO NO ARQUIVO ATRAVÉS DO ID 
//VALE RESSALTAR QUE O ID SERVE COMO IDENTIFICADOR, POR EXEMPLO, NUMA TABELA DE 
//BANCO DE DADOS
    public int buscaId(int id){
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux = elemento.get("id").toString();
                //System.out.println(aux);
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
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux = elemento.get("nome").toString();
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
            Path path = Paths.get(file);
            boolean notExists = Files.notExists(path);
            if(notExists){
                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file));    
                    bw.write("{\"biscoito\": []}"); 
                    bw.close();
                }
                catch(Exception ex){
                    return "DEU ERRADO"; 
                }
            }    
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
            
            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux += ("ID: " + elemento.get("id") +
                        "\nNome: " + elemento.get("nome").toString() +
                        "\nValor: " + elemento.get("valor") +
                        "\nQuantidade Disponivel: " + elemento.get("quantidadeDisponivel") +
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

    //ESSE METODO SERVE PARA PERCORRER O ARRAY JSON E ENCONTRAR 
    //UM BISCOITO EM ALGUMA POSIÇÃO DA "TABELA"
    //AO ENCONTRAR, ELE RETORNA O INDICE DO OBJETO NAQUELA POSIÇÃO
    //E PERMITE RECUPERAR INFORMAÇÕES EQUIVALENTES
    public int percorrerArray(){
        int maior = 0;
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("biscoito");
            
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
