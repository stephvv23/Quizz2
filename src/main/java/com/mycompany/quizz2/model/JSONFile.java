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
 * @author Usuario /Esta clase solo nos va a servir para leer y escribir
 */
public class JSONFile {

    private String fileName;
    private JSONArray jsonArray;
    private JSONObject jsonObject;
    private JSONParser jsonParser;

    public JSONFile(String fileName) {
        this.fileName = fileName;
        this.jsonArray = new JSONArray();
        this.jsonObject = new JSONObject();
    }

    public JSONArray read() {
        this.jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {
            Object obj = this.jsonParser.parse(reader);
            this.jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            System.out.print("kk");
        }
        return this.jsonArray;
    }

    public void writer(JSONObject jsonObjet) {
        this.jsonArray = this.read();
        this.jsonArray.add(jsonObjet);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(this.jsonArray.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.print("kk");

        }
    }

    public void writerArray(JSONArray jsonArray) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(jsonArray.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.print("kk");

        }
    }
}
