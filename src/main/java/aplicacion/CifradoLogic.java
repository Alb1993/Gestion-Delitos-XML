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
    public static String cifrarInforme(StringBuilder text, int contraseña) {

        // Creamos un array con los caracteres
        char[] chars = text.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLowerCase(c)) {
                chars[i] = (char) ('z' - (c - 'a') - contraseña);
            } else if (Character.isUpperCase(c)) {
                chars[i] = (char) ('Z' - (c - 'A') - contraseña);
            }
        }
        return new String(chars);
    }

    /**
     * Función para pasar un archivo a String para luego cifrar
     *
     * @param fileName
     * @param contraseña
     * @return
     */
    public static String fileToString(String fileName, String contraseña) {
        int contraseñaLong = contraseña.length();
        
        StringBuilder content = new StringBuilder();
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                content.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {

        }

        return cifrarInforme(content, contraseñaLong);
    }

    /**
     * Función para pasar un String a Archivo para luego crear el archivo
     * cifrado
     *
     * @param content
     * @param fileName
     * @param extension
     */
    public static void stringToFile(String content, String fileName, String extension) {
        try (FileWriter writer = new FileWriter(new File(fileName + extension))) {
            writer.write(content);
        } catch (IOException e) {

        }
    }
}
