package aplicacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * Función para cifrar el documento en modo espejo (estas funciones no nos
     * funcionan, hemos tenido que utilizar al final el cifrado cesar para que
     * por lo menos tengamos un cifrado)
     *
     * @param text
     * @param contraseña
     * @return
     */
    public static StringBuilder cifrarInforme(StringBuilder text, int contraseña) {

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLowerCase(c)) {
                char resultadoLower = (char) ('z' - (c - 'a') - contraseña);

                if (resultadoLower < 'a') {
                    resultadoLower = 'a';
                } else if (resultadoLower > 'z') {
                    resultadoLower = 'z';
                }

                text.setCharAt(i, resultadoLower);

            } else if (Character.isUpperCase(c)) {
                char resultadoUpper = (char) ('Z' - (c - 'A') - contraseña);

                if (resultadoUpper < 'A') {
                    resultadoUpper = 'A';
                } else if (resultadoUpper > 'Z') {
                    resultadoUpper = 'Z';
                }
                text.setCharAt(i, resultadoUpper);
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

    /**
     * Función de cifrado con el metodo cesar
     * 
     * @param contraseña
     * @param inputFile
     * @param outputFile 
     */
    public static void cifrado(String contraseña, String inputFile, String outputFile) {

        int contraseñaInt = contraseña.length();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                char encrypted = (char) (ch + contraseñaInt);
                writer.write(encrypted);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funcion de descifrado con el metodo cesar
     * 
     * @param contraseña
     * @param inputFile
     * @param outputFile 
     */
    public static void descifrado(String contraseña, String inputFile, String outputFile) {

        int contraseñaInt = contraseña.length();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                char decrypted = (char) (ch - contraseñaInt);
                writer.write(decrypted);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
