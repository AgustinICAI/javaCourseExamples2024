package examen2023.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Config {
    public static HashMap<String, String> LoadConfig() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("./resources/config.txt")));
        String linea;
        HashMap<String, String> config = new HashMap<>();
        while((linea = br.readLine())!=null) {
            String[] campos = linea.split(":");
            config.put(campos[0].trim(),campos[1].trim());
        }
        return config;
    }
}
