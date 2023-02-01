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

        Informe informe1 = InformesDAO.numeroDelitosTipo232(delitos);
        return informe1;
    }

    public Informe cargarInforme2(ArrayList<Row> delitos) {

        Informe informe2 =  InformesDAO.numeroDelitosGrupo102(delitos);
        return informe2;
    }

    public Informe cargarInforme3(ArrayList<Row> delitos) {

        Informe informe3 = InformesDAO.numeroDelitosGrupo111(delitos);
        return informe3;
    }

    public void crearInforme(File archivo, Informe informe) throws IOException {
        if (archivo != null) {
            
          InformesDAO.crearArchivoInforme(archivo, informe);           
        }

    }
}
