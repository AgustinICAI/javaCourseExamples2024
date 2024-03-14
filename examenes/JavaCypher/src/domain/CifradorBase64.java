package domain;

import java.util.Base64;

public class CifradorBase64 extends Cifrador {

    @Override
    public String cifra(String mensaje) {
        return Base64.getEncoder().encodeToString(mensaje.getBytes());

    }
}
