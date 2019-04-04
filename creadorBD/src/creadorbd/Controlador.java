/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorbd;

import com.mysql.jdbc.Connection;

/**
 *
 * @author ~Antares~
 */
public class Controlador {

    private Conexion conexion;
    private CreadorBD creador;
    private String usuario;
    private String pass;
    private String nombreBD;

    public Controlador() {
        VentanaInicial ventana = new VentanaInicial(this);
        ventana.setVisible(true);

    }

    private void conectar() {
        conexion = new Conexion(usuario, pass);
    }

    private Connection getConexionInicial() {
        return conexion.getConexionInicial();
    }

    private Connection getConexionBD() {
        return conexion.getConexionBD(nombreBD);
    }

    public void crear(String usuarioX, String passX, String nombreBDX) {

        usuario = usuarioX;
        pass = passX;
        nombreBD = nombreBDX;

        System.out.println("usuario = " + usuarioX);
        System.out.println("pass = " + passX);
        System.out.println("nombreBD = " + nombreBDX);

        //conecter
        conectar();
        //obtner conexion  & cread BD
        creador = new CreadorBD(getConexionInicial(), nombreBD);
        //crear tablas
        creador.crearTablas(getConexionBD());
        if (creador.getEstado()) {
            //iniciar el programa de invantariado
        }

    }

}
