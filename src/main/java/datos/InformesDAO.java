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
 *Clase donde se crean los informes que se mostraran en la psntalla de informe
 * @author andre
 */
public class InformesDAO {
    /*
    Función por la cual creamos el contenido el informe 1 
    @param delitos
    @return informe1
    */
    public static Informe numeroDelitosTipo232(ArrayList<Row> delitos) {
        // creamos el informe
        Informe informe1 = new Informe();
        //establecemos el titulo del informe
        informe1.setTitulo("Cuantos delitos de tipo 'Robatori amb violència o intimidació' se han cometido en el año 2022 en las Islas Baleares");
        //creamos una lista solo con los objetos filtrados
        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCoditipusdelicte().equals("232")
                && d.getComissiofets().split("-")[0].equals("2022") && d.getCodicomunitatautonoma().equals("04")).collect(Collectors.toList());
        
        //recogemos el el tamaño de la lista
        int numDelitos232 = objetosFiltrados.size();
        //creamos la decripción del informe
        String descripción = "En las Islas Baleares durante el año 2022 se han cometido un total de " + numDelitos232 + " delitos de tipo 'Robatori amb violència o intimidació'";
        //establecemos la decripción del informe
        informe1.setInfromacion(descripción);
        
        return informe1;
    }
    /*
    Función por la cual creamos el contenido el informe 2 
    @param delitos
    @return informe2
    */
    public static Informe numeroDelitosGrupo102(ArrayList<Row> delitos) {
        // creamos el informe
        Informe informe2 = new Informe();
        //establecemos el titulo del informe
        informe2.setTitulo("Cuantos delitos del grupo de delitos 'De les lesions' se han cometido durante el año 2021 en las Islas Baleares por hombres");
        //creamos una lista solo con los objetos filtrados
        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCodigrupdelicte().equals("102")
                && d.getComissiofets().split("-")[0].equals("2021") && d.getCodicomunitatautonoma().equals("04") && d.getSexe().equals("H")).collect(Collectors.toList());
 
        //recogemos el el tamaño de la lista
        int numDelitos102 = objetosFiltrados.size();
        //creamos la decripción del informe
        String descripción = "En las Islas Baleares durante el año 2021 se han cometido un total de " + numDelitos102 + " delitos del grupo 'De les lesions' por hombres";
        //establecemos la decripción del informe
        informe2.setInfromacion(descripción);
        
        return informe2;
    }
    
    /*
    Función por la cual creamos el contenido el informe 3
    @param delitos
    @return informe3
    */
    public static Informe numeroDelitosGrupo111(ArrayList<Row> delitos) {
        // creamos el informe
        Informe informe3 = new Informe();
        //establecemos el titulo del informe
        informe3.setTitulo("Cuantos delitos del grupo de delitos 'Delictes contra el patrimoni i contra l'ordre socioeconòmic' se han cometido durante el año 2020");
         //creamos una lista solo con los objetos filtrados
        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCodigrupdelicte().equals("111")
                && d.getComissiofets().split("-")[0].equals("2020")).collect(Collectors.toList());
        //recogemos el el tamaño de la lista
        int numDelitos111 = objetosFiltrados.size();
        //creamos la decripción del informe 
        String descripción = "Durante el año 2020 se han cometido un total de " + numDelitos111 + " delitos del grupo 'Delictes contra el patrimoni i contra l'ordre socioeconòmic'";
        //establecemos la decripción del informe
        informe3.setInfromacion(descripción);
        
        return informe3;

        
    }
    /*
    Función para crear elarchivo y escribir la información en el archivo
    @param archivo, informe
    @throws IOException 
    */
    public static void crearArchivoInforme(File archivo, Informe informe) throws IOException {
        //si el archivo no existe
        if (!archivo.exists()) {
            //comprobamos si el archivo no tiene la estesion .txt
            if(!archivo.getName().endsWith(".txt")){
                //si no lo tiene aregamos la extención
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            //creamos el archivo 
            archivo.createNewFile();
        }
        //creamos  un BufferedWriter para poder escribir en archivo 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            //escribimos el contenido del ijnforme en el archivo
            bw.write(informe.getTitulo());
            bw.newLine();
            bw.newLine();
            bw.write(informe.getInfromacion());
            bw.close();
        }
        
    }
}
