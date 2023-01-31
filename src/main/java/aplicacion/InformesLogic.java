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
 *
 * @author andre
 */
public class InformesLogic {

    public InformesLogic() {

    }

    public Informe cargarInforme1(ArrayList<Row> delitos) {

        Informe informe1 = new Informe();
        informe1.setTitulo("Cuantos delitos de tipo 'Robatori amb violència o intimidació' se han cometido en el año 2022 en las Islas Baleares");
        int numDelitos232 = InformesDAO.numeroDelitosTipo232(delitos);
        String descripción = "En las Islas Baleares durante el año 2022 se han cometido un total de " + numDelitos232 + " de tipo 'Robatori amb violència o intimidació'";
        informe1.setInfromacion(descripción);
        return informe1;
    }

    public Informe cargarInforme2(ArrayList<Row> delitos) {

        Informe informe2 = new Informe();
        informe2.setTitulo("Cuantos delitos del grupo de delitos 'De les lesions' se han cometido durante el año 2021 en la comindad autonama de Andalucía por hombres");
        int numDelitos102 = InformesDAO.numeroDelitosGrupo102(delitos);
        String descripción = "En Andalucía durante el año 2021 se han cometido un total de " + numDelitos102 + " del grupo 'De les lesions' por hombres";
        informe2.setInfromacion(descripción);
        return informe2;
    }

    public Informe cargarInforme3(ArrayList<Row> delitos) {

        Informe informe3 = new Informe();
        informe3.setTitulo("Cuantos delitos del grupo de delitos 'Delictes contra el patrimoni i contra l'ordre socioeconòmic' se han cometido durante el año 2020");
        int numDelitos111 = InformesDAO.numeroDelitosGrupo111(delitos);
        String descripción = "Durante el año 2020 se han cometido un total de " + numDelitos111 + " del grupo 'Delictes contra el patrimoni i contra l'ordre socioeconòmic'";
        informe3.setInfromacion(descripción);
        return informe3;
    }

    public void crearInforme(File archivo, Informe informe) throws IOException {
        if (archivo != null) {
            
          InformesDAO.crearArchivoInforme(archivo, informe);           
        }

    }
}
