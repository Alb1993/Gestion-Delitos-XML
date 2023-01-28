package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FPShare
 */
public class CifradoDAO {

    /**
     * Función para cifrar el informe en modo espejo
     *
     * @param text
     * @return
     */
    public static String cifrarInforme(String text) {

        // Creamos un array con los caracteres
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLowerCase(c)) {
                chars[i] = (char) ('z' - (c - 'a'));
            } else if (Character.isUpperCase(c)) {
                chars[i] = (char) ('Z' - (c - 'A'));
            }
        }
        return new String(chars);
    }

    /**
     * Función para descifrar utilizando la misma función de cifrar para
     * revertir el cifrado
     *
     * @param text
     * @return
     */
    public static String descifrarInforme(String text) {
        return cifrarInforme(text);
    }

    /**
     * Función para pasar un archivo a String para luego cifrar
     *
     * @param fileName
     * @return
     */
    public static String fileToString(String fileName) {
        StringBuilder content = new StringBuilder();
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                content.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {

        }

        return cifrarInforme(content.toString());
    }

    /**
     * Función para pasar un String a Archivo para luego crear el archivo
     * cifrado
     *
     * @param content
     * @param fileName
     */
    public static void stringToFile(String content, String fileName) {
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            writer.write(content);
        } catch (IOException e) {

        }
    }
}
