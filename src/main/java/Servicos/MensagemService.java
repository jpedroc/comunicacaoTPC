package Servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MensagemService {

    public static String toConteudo(ArrayList<String> enderecos) {
        return enderecos.toString();
    }

    public static List<String> toArray(String conteudo) {
        return Arrays.asList(conteudo.split(","));
    }
}
