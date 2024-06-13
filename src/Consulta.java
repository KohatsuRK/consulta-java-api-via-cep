import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    private Endereco endereco;

    public Endereco consultaCep(String CEP) throws IOException, InterruptedException {
        if(CEP.length()!=8){
            throw new ErroCepInvalidoException("CEP INVÁLIDO! TAMANHO DIFERENTE DO PADRÃO");
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+ CEP +"/json/")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        return new Gson().fromJson(json,Endereco.class);
    }





}
