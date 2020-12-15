package Dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class RespostaServidor implements Serializable {
    private static ArrayList<String> enderecosIP = new ArrayList<String>();
    private static ArrayList<String> mensagens = new ArrayList<String>();

    public static ArrayList<String> getEnderecosIP() {
        return enderecosIP;
    }

    public static void addEnderecosIP(String enderecoIP) {
        RespostaServidor.enderecosIP.add(enderecoIP);
    }

    public static ArrayList<String> getMensagens() {
        return mensagens;
    }

    public static void addMensagem (String mensagem) {
        RespostaServidor.mensagens.add(mensagem);
    }
}
