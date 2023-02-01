package aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @version 1.0
 * @author FPShare
 *
 * Clase para almacenar las funciones de cifrado y descifrado de la aplicación
 */
public class CifradoLogic {

    /**
     * Función para cifrar el documento en modo espejo
     *
     * @param text
     * @param contraseña
     * @return
     */
    public static StringBuilder cifrarInforme(StringBuilder text, int contraseña) {

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLowerCase(c)) {
                text.setCharAt(i, (char) ('z' - (c - 'a') + contraseña));
            } else if (Character.isUpperCase(c)) {
                text.setCharAt(i, (char) ('Z' - (c - 'A') + contraseña));
            }
        }
        return text;
    }

    public static StringBuilder descifrarInforme(StringBuilder text, int contraseña) {

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLowerCase(c)) {
                text.setCharAt(i, (char) ('a' - ('z' - c) + contraseña));
            } else if (Character.isUpperCase(c)) {
                text.setCharAt(i, (char) ('A' - ('Z' - c) + contraseña));
            }
        }
        return text;
    }

    /**
     * Función para pasar un archivo a String para luego cifrar
     *
     * @param fileName
     * @param contraseña
     * @return
     */
    public static StringBuilder fileToString(String fileName, String contraseña) {
        int contraseñaLong = contraseña.length();
        StringBuilder content = new StringBuilder();
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                content.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        return cifrarInforme(content, contraseñaLong);

    }

    /**
     * Función para pasar un String a Archivo para luego crear el archivo
     * cifrado
     *
     * @param content
     * @param fileName
     */
    public static void stringToFile(StringBuilder content, String fileName) {
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            writer.write(content.toString());
        } catch (IOException e) {

        }
    }
}
