package Recursos;

import Dominio.Mensagem;
import Dominio.RespostaServidor;
import Servicos.MensagemService;
import Servicos.ProcessarMensagemServidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static final int PORTA = 9000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        Mensagem mensagem;
        Mensagem resposta = null;

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            serverSocket = new ServerSocket(PORTA);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            // conexão
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // escutando
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // recebendo msg
            try {
                mensagem = (Mensagem) objectInputStream.readObject();
                new ProcessarMensagemServidor(mensagem).start();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // enviar resposta

            try {
                resposta = new Mensagem(MensagemService.toConteudo(RespostaServidor.getEnderecosIP()));
                objectOutputStream.writeObject(resposta);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
