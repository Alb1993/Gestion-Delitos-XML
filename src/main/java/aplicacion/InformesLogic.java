/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.InformesDAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Informe;
import modelo.Row;

/**
 * Clase donde se se encuentran la logica de los informes
 * @author andre
 */
public class InformesLogic {
    /*
    Constructor de InformesLogic
    */
    public InformesLogic() {

    }
    /*
    Función con la cual recibimos el informe 1 de la capa de datos y lo devolvemos
    @param delitos
    @return informe1
    */
    public Informe cargarInforme1(ArrayList<Row> delitos) {

        Informe informe1 = InformesDAO.numeroDelitosTipo232(delitos);
        return informe1;
    }
    
     /*
    Función con la cual recibimos el informe 2 de la capa de datos y lo devolvemos
    @param delitos
    @return informe2
    */
    public Informe cargarInforme2(ArrayList<Row> delitos) {

        Informe informe2 =  InformesDAO.numeroDelitosGrupo102(delitos);
        return informe2;
    }
    
     /*
    Función con la cual recibimos el informe 3 de la capa de datos y lo devolvemos
    @param delitos
    @return informe3
    */
    public Informe cargarInforme3(ArrayList<Row> delitos) {

        Informe informe3 = InformesDAO.numeroDelitosGrupo111(delitos);
        return informe3;
    }
    
    /*
    Fuinción con la que comprobamos si el archivo recibido no es null, si no es null llamanos a la función que creara el archivo
    @param archivo, informe
    @throws IOException
    */
    public void crearInforme(File archivo, Informe informe) throws IOException {
        if (archivo != null) {
            
          InformesDAO.crearArchivoInforme(archivo, informe);           
        }

    }
}
