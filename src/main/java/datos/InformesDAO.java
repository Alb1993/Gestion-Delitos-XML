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

    public static int numeroDelitosTipo232(ArrayList<Row> delitos) {

        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCoditipusdelicte().equals("232")
                && d.getComissiofets().split("-")[0].equals("2022") && d.getCodicomunitatautonoma().equals("04")).collect(Collectors.toList());

        return objetosFiltrados.size();
    }

    public static int numeroDelitosGrupo102(ArrayList<Row> delitos) {

        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCodigrupdelicte().equals("102")
                && d.getComissiofets().split("-")[0].equals("2021") && d.getCodicomunitatautonoma().equals("01") && d.getSexe().equals("H")).collect(Collectors.toList());

        return objetosFiltrados.size();
    }

    public static int numeroDelitosGrupo111(ArrayList<Row> delitos) {

        List<Row> objetosFiltrados = delitos.stream().filter(d -> d.getCodigrupdelicte().equals("111")
                && d.getComissiofets().split("-")[0].equals("2020")).collect(Collectors.toList());

        return objetosFiltrados.size();
    }

    public static void crearArchivoInforme(File archivo, Informe informe) throws IOException {
        
        if (!archivo.exists()) {
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
