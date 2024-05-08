/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 * /Esta clase solo nos va a servir para leer y escribir
 */
public class JSONFile {
    private String fileName;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private JSONParser parser;
    
    //le pasamos cualquier archivo y va a trabajar con ese, asi que es reutilizable
    public JSONFile(String fileName){
        
        this.fileName = fileName;
        this.jsonObject = new JSONObject();
        this.jsonArray = new JSONArray();
    }
    
    //leer cualquier JSON
    public JSONArray read(){ //devuelve un JSONArray ya listo
        this.parser = new JSONParser();
        try(FileReader reader = new FileReader(fileName)){
            Object obj = this.parser.parse(reader);
            this.jsonArray = (JSONArray) obj;
        }catch(IOException | ParseException e){
            System.err.println("No existing file or new file will be create.");
        }
        return this.jsonArray;
    }
    
    //para escribir objeto por objeto
    public void  writer(JSONObject jsonObject){
        this.jsonArray = this.read(); //leer el archivo y cargarlo
        this.jsonArray.add(jsonObject); //se añade, no importa que trae el objeto  
        try(FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(this.jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        }catch(IOException e){
            
        }
    }
    
    //para escribir un JSONArray
    public void writerArray(JSONArray jsonArray) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(this.jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("No posible read.");
        }
    }
}
