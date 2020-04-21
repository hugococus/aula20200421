/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula21042020;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String Args[]) throws MalformedURLException, IOException {

        URL url = new URL("http://porose-delegate.000webhostapp.com/Leitura.php");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);

       
        Gson json = new Gson();

        try {
            InputStream resposta = conn.getInputStream();
            InputStreamReader resposta_comp = new InputStreamReader(resposta);
            BufferedReader resposta_formatada = new BufferedReader(resposta_comp);
            String resposta_php = resposta_formatada.readLine();
            if (resposta_php != null) {
                
                pessoa[] pessoas = json.fromJson(resposta_php, pessoa[].class);
                
                for (int i = 0; i < pessoas.length; i++) {
                    pessoas[i].relatorio();
                }
                
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
