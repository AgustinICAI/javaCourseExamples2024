package domain;

import util.UtilCypher;

import java.util.HashMap;

public class CifradorAscii extends Cifrador {

    @Override
    public String cifra(String mensaje) {
        StringBuilder sb = new StringBuilder();

        for(char c : mensaje.toCharArray())
                sb.append((int)c).append(" ");


        return sb.toString();

    }
}
