package Recursos;

import Dominio.Mensagem;
import Dominio.RespostaServidor;
import Servicos.MensagemService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClientTCP {

    private static final int PORTA = 9000;

    public static void main(String[] args) {
        String servidor = "Server";
        Socket socket = null;
        InetAddress enderecoServidor = null;
        Mensagem mensagem;
        Mensagem resposta = null;
        Scanner ler = new Scanner(System.in);

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            enderecoServidor = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            socket = new Socket(enderecoServidor, PORTA);
        } catch (IOException e) {
            e.printStackTrace();
        }
            // iniciar
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // enviar mensagem
            try {
                System.out.print("Escreva a mensagem: ");
                mensagem = new Mensagem(ler.next());
                mensagem.setEnderecoIP(enderecoServidor.getHostAddress());
                objectOutputStream.writeObject(mensagem);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // aguardar resposta
            try {
                resposta = (Mensagem) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // apresentar resposta
            if (resposta instanceof Mensagem) {
                List<String> enderecos = MensagemService.toArray(resposta.getConteudo());
                enderecos.forEach(element -> {
                    System.out.println("Endereço: " + element);
                });
            }

    }
}
