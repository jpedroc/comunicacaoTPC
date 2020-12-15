package Servicos;

import Dominio.Mensagem;
import Dominio.RespostaServidor;

public class ProcessarMensagemServidor extends Thread{

    private Mensagem mensagem;

    public ProcessarMensagemServidor(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void run() {
        try {
            if(RespostaServidor.getEnderecosIP().contains(this.mensagem.getEnderecoIP())) {
                RespostaServidor.addEnderecosIP(this.mensagem.getEnderecoIP());
            }
            RespostaServidor.addMensagem(this.mensagem.getConteudo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
