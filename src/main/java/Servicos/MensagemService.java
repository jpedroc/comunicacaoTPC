package Servicos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MensagemService {

    public static String toConteudo(ArrayList<String> enderecos) {
        return enderecos.toString();
    }

    public static ArrayList<String> toArray(String conteudo) {
        return (ArrayList<String>) Arrays.asList(conteudo.split(","));
    }
}
