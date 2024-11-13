package persistencia;

//IMPORT DAS BIBLIOTECAS NECESSÁRIAS PARA IMPLEMENTAR O JSON (PERSISTENCIA)
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

//IMPORT DE TODOS CÓDIGOS EXISTENTES NO PACOTE DESSE PROGRAMA
import modelo.*;

public class PersistenciaCliente implements Persistencia {
    private String file = "src/arquivo/arquivoCliente.json";

    //METODO SERVE PARA INSERIR UM CLIENTE NA "TEBALA" QUE 
    //CONTÉM OS ARQUIVOS EM DISCO DOS CLIENTES CADASTRADOS
    //A PROPÓSITO, POR TABELA, ENTENDA-SE DAQUI EM DIANTE, 
    //ARQUIVO JSON ARMAZENADO EM DISCO 

    public void insere(Entidade entidade){

        JSONObject insere = new JSONObject();
        insere.put("nome",((Cliente)entidade).getNome());
        insere.put("saldo",((Cliente)entidade).getSaldo());


        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            Path path = Paths.get(file);
            boolean notExists = Files.notExists(path);

            if(notExists){
                try{
                    BufferedWriter bw = new BufferedWriter(
                        new FileWriter(file));    
                    bw.write("{\"cliente\": []}"); 
                    bw.close();
                }
                catch(Exception ex){
                    return; 
                }
            }

            insere.put("id", this.percorrerArray() + 1);

            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");          
            jsonArray.add(insere);
            

            JSONObject guarda = new JSONObject();
            guarda.put("cliente",jsonArray);

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
    
    //ESSA FUNÇÃO PERMITE CARREGAR TODOS OS DADOS DA "TABELA"
    //E ALTERAR ALGUMA "LINHA" (OBJETO JS) DO ARQUIVO
    //ELA RECEBE PARÁMETROS BISCOITO E EMBALAGEM POIS É SIMPLISMENTE SOBREESCRITA
    //NAS CLASSES PERSISTENCIAS RESPECTIVAMENTE EQUIVALENTES 
    public void altera(Entidade entidade){

        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
            JSONObject elemento = (JSONObject) jsonArray.get(buscaString(((Venda)entidade).getClienteNome()));

            JSONObject objAltera= new JSONObject();
            objAltera.put("id", elemento.get("id"));
            objAltera.put("nome", elemento.get("nome").toString());
            objAltera.put("saldo", ((Venda)entidade).getClienteSaldo());

            
            jsonArray.remove(jsonArray.get(buscaString(((Venda)entidade).getClienteNome())));
            jsonArray.add(objAltera);


            JSONObject guarda = new JSONObject();
            guarda.put("cliente",jsonArray);

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

    //ESSE METODO ACESSA OS DADOS DE arquivoCliente.json
    //PARA EXCLUIR UM DETERMINADO DADO, PESQUISADO IN CODE PELA MAIN
    public void exclui(int id, String nome){
        if(id > 0){
            //Creating a JSONParser object
            JSONParser jsonParser1 = new JSONParser();
            try {
                //Parsing the contents of the JSON file
                JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader(file));
                            
                //Retrieving the array
                JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
                jsonArray.remove(jsonArray.get(buscaId(id)));

                JSONObject guarda = new JSONObject();
                guarda.put("cliente",jsonArray);

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
                JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
                jsonArray.remove(jsonArray.get(buscaString(nome)));

                JSONObject guarda = new JSONObject();
                guarda.put("cliente",jsonArray);

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



    //É TRIVIAL. BUSCA O ID DE UM OBJETO CLIENTE NO ARQUIVO .JSON DA CLASSE CLIENTE
    //E RETORNA A POSIÇÃO DO ID PESQUISADO. A COMPREENSÃO DO CODIGO FICA A CARGO DO LEITOR
    public int buscaId(int id){
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
            
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

    //DE FORMA SIMILAR À buscaId(), ESSE METODO RETORNA A POSIÇÃO DO JSON ARRAY
    //QUE CONTÉM AQUELA STRING PESQUISADA
    public int buscaString(String string){
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
            
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
                    bw.write("{\"cliente\": []}"); 
                    bw.close();
                }
                catch(Exception ex){
                    return "DEU ERRADO"; 
                }
            }
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");

            for (int i=0; i < jsonArray.size() ; i++){
                JSONObject elemento = (JSONObject) jsonArray.get(i);
                aux += ("ID: " + elemento.get("id")+
                        "\nNome: " + elemento.get("nome").toString() +
                        "\nSaldo: " + elemento.get("saldo") +
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
    //UM CLIENTE EM ALGUMA POSIÇÃO DA "TABELA"
    //AO ENCONTRAR, ELE RETORNA O INDICE DO OBJETO NAQUELA POSIÇÃO
    //E PERMITE RECUPERAR INFORMAÇÕES OUTRAS DAQUELE OBJETO
    public int percorrerArray(){
        int maior = 0;
        String aux;
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");
            
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
