package Dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Mensagem implements Serializable {
    private String enderecoIP;
    private String conteudo;
    private LocalDate dataHora;

    public Mensagem(String conteudo) {
        this.conteudo = conteudo;
        this.dataHora = LocalDate.now();
    }

    public String getEnderecoIP() {
        return enderecoIP;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setEnderecoIP(String enderecoIP) {
        this.enderecoIP = enderecoIP;
    }
}
