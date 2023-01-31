/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author andre
 */
public class Informe {

    private String titulo;

    private String infromacion;

    public Informe() {
    }

    public Informe(String titulo, String infromacion) {
        this.titulo = titulo;
        this.infromacion = infromacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInfromacion() {
        return infromacion;
    }

    public void setInfromacion(String infromacion) {
        this.infromacion = infromacion;
    }
}
