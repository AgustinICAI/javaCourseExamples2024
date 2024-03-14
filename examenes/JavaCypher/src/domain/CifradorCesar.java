package domain;

import util.UtilCypher;

import java.util.HashMap;

public class CifradorCesar extends Cifrador {
    HashMap<Character,Integer> hmMinusculas;
    HashMap<Character,Integer> hmMayusculas;
    int desplazamiento;
    public CifradorCesar(int desplazamiento){
        this.desplazamiento = desplazamiento;
        hmMinusculas = new HashMap<>();
        hmMayusculas = new HashMap<>();
        for(int i = 0 ; i < UtilCypher.lowerLetters.length; i++)
            hmMinusculas.put(UtilCypher.lowerLetters[i],i);
        for(int i = 0 ; i < UtilCypher.upperLetters.length; i++)
            hmMayusculas.put(UtilCypher.upperLetters[i],i);

    }
    @Override
    public String cifra(String mensaje) {
        StringBuilder sb = new StringBuilder();

        for(char c : mensaje.toCharArray()){
            if( hmMinusculas.containsKey(c)){
                int posFinal = (hmMinusculas.get(c) + desplazamiento)%26;
                sb.append(UtilCypher.lowerLetters[posFinal]);
            } else if( hmMayusculas.containsKey(c)){
                int posFinal = (hmMayusculas.get(c) + desplazamiento)%26;
                sb.append(UtilCypher.upperLetters[posFinal]);
            }
            else
                sb.append(c);
        }

        return sb.toString();

    }
}
