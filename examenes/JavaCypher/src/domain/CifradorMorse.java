package domain;

import util.UtilCypher;

import java.util.HashMap;

public class CifradorMorse extends Cifrador {
    HashMap<Character, String> hmConversion;

    public CifradorMorse(){
        hmConversion = new HashMap<>();
        for(int i = 0; i < UtilCypher.letters.length; i ++)
            hmConversion.put(UtilCypher.letters[i],
                             UtilCypher.morseConversion[i]);
    }
    @Override
    public String cifra(String mensaje) {
        StringBuilder sb = new StringBuilder();

        for(char c : mensaje.toLowerCase().toCharArray()){
            if (c == ' ')
                sb.append(".......");
            else
                sb.append(hmConversion.get(c));
            sb.append(" ");
        }

        return sb.toString();

    }
}
