package javaapplication6;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Main{
    // one instance, reuse

    public static void main(String Args[]) throws MalformedURLException, IOException {
        URL url = new URL("http://porose-delegate.000webhostapp.com/Insere.php");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("User-Agent", "Java");
        conn.setRequestProperty("Accept-Language", "UTF-8");
        
        Gson json = new Gson();
        Pessoa pessoa = new Pessoa("Ciclano de Tal", "11122244455");

        StringBuilder dados = new StringBuilder();
        dados.append("JSON=");
        dados.append(URLEncoder.encode(json.toJson(pessoa), "UTF-8"));

        OutputStreamWriter outputStreamWriter = null;

        try {
            outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
            outputStreamWriter.write(dados.toString());
            outputStreamWriter.flush();

            System.out.println(dados.toString());
            InputStream resposta = conn.getInputStream();
            InputStreamReader resposta_comp = new InputStreamReader(resposta);
            BufferedReader resposta_formatada = new BufferedReader(resposta_comp);
            String cara = resposta_formatada.readLine();
            if (cara != null) {
                System.out.println(cara);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            outputStreamWriter.close();
        }

    }

}
