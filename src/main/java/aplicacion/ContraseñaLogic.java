package aplicacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @author FPShare
 * 
 * Clase para almacenar las funcionalidades de comprobación de contraseña
 */
public class ContraseñaLogic {

    /**
     * Función para detectar si la contraseña introducida cumple con los
     * requisitos
     *
     * @param contraseña
     * @return
     * @throws Exception
     */
    public static boolean escrituraContraseña(String contraseña) throws Exception {
        boolean ret = false;
        String matcherContraseña = "[^a-zA-Z0-9]{4,20}";

        Pattern pat = Pattern.compile(matcherContraseña);
        Matcher mat = pat.matcher(contraseña);

        if (mat.matches()) {
            ret = true;
        } else {
            throw new Exception("La contraseña no es valida, tiene que ser entre 4 y 20 caracteres");
        }

        return ret;
    }
}
