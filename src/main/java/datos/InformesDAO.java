/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Informe;
import modelo.Row;

/**
 *
 * @author andre
 */
public class InformesDAO {

    public static Informe numeroDelitosTipo232(ArrayList<Row> delitos) {
        Informe informe1 = new Informe();
        informe1.setTitulo("Cuantos delitos de tipo 'Robatori amb violència o intimidació' se han cometido en el año 2022 en las Islas Baleares");
        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCoditipusdelicte().equals("232")
                && d.getComissiofets().split("-")[0].equals("2022") && d.getCodicomunitatautonoma().equals("04")).collect(Collectors.toList());

        int numDelitos232 = objetosFiltrados.size();
        String descripción = "En las Islas Baleares durante el año 2022 se han cometido un total de " + numDelitos232 + " delitos de tipo 'Robatori amb violència o intimidació'";
        informe1.setInfromacion(descripción);
        
        return informe1;
    }

    public static Informe numeroDelitosGrupo102(ArrayList<Row> delitos) {
        
        Informe informe2 = new Informe();
       
        informe2.setTitulo("Cuantos delitos del grupo de delitos 'De les lesions' se han cometido durante el año 2021 en las Islas Baleares por hombres");
        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCodigrupdelicte().equals("102")
                && d.getComissiofets().split("-")[0].equals("2021") && d.getCodicomunitatautonoma().equals("04") && d.getSexe().equals("H")).collect(Collectors.toList());
 

        int numDelitos102 = objetosFiltrados.size();
        
        String descripción = "En las Islas Baleares durante el año 2021 se han cometido un total de " + numDelitos102 + " delitos del grupo 'De les lesions' por hombres";
        informe2.setInfromacion(descripción);
        
        return informe2;
    }

    public static Informe numeroDelitosGrupo111(ArrayList<Row> delitos) {
        
        Informe informe3 = new Informe();
        informe3.setTitulo("Cuantos delitos del grupo de delitos 'Delictes contra el patrimoni i contra l'ordre socioeconòmic' se han cometido durante el año 2020");
        
        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCodigrupdelicte().equals("111")
                && d.getComissiofets().split("-")[0].equals("2020")).collect(Collectors.toList());
        
        int numDelitos111 = objetosFiltrados.size();
        
        String descripción = "Durante el año 2020 se han cometido un total de " + numDelitos111 + " delitos del grupo 'Delictes contra el patrimoni i contra l'ordre socioeconòmic'";
        informe3.setInfromacion(descripción);
        
        return informe3;

        
    }

    public static void crearArchivoInforme(File archivo, Informe informe) throws IOException {
        
        if (!archivo.exists()) {
            if(!archivo.getName().endsWith(".txt")){
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            archivo.createNewFile();
        }
     
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(informe.getTitulo());
            bw.newLine();
            bw.newLine();
            bw.write(informe.getInfromacion());
        }
        
    }
}
