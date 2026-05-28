package br.com.fiap.challenge.ouro.service;

import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class ConsultaIA {
    private Client client = Client.builder().apiKey("AIzaSyC_yDPDUaGgp4I5EN5ZUGY28xa_bn8XG4g").build();

    private final String prompt = """
            Está é a transcrição de uma reunião, tente extrair dela o máximo de informações possíveis.
            Com elas, faça um pequeno relatório daquilo que realmente pode ser perdido durante ela.
            segue transcrição:
            """;

    public String consultaComTexto(String entrada) {
        GenerateContentResponse response =
                client.models.generateContent("gemini-3.5-flash", prompt + entrada, null);

        return response.text();
    }
}
