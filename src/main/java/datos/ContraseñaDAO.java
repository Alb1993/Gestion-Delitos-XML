/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FPShare
 */
public class ContraseñaDAO {

    /**
     * Función para escribir contraseña para cifrar o descifrar el informe
     *
     * @param contraseña
     * @return
     * @throws Exception
     */
    public String escrituraContraseña(String contraseña) throws Exception {
        String matcherContraseña = "[^a-zA-Z]";

        Pattern pat = Pattern.compile(matcherContraseña);
        Matcher mat = pat.matcher(contraseña);

        if (mat.matches()) {

        } else {
            throw new Exception("La contraseña no es valida");
        }

        return contraseña;
    }
}
