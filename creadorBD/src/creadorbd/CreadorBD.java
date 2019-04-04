/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorbd;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ~Antares~
 */
public class CreadorBD {

    private String nombreBD = "aleatorio";
    private PreparedStatement statement;
    private ResultSet result;

    private Connection conexionInicial;
    private Connection conexionBD;

    private boolean estado = true;

    public CreadorBD(Connection conX, String nombreBDX) {
        conexionInicial = conX;
        nombreBD = nombreBDX;
        crearBD();
    }

    private void crearBD() {
        try {
            //inicio eliminacion de base de datos (NombreBD)
            String sql = "CREATE DATABASE IF NOT EXISTS " + nombreBD;
            statement = conexionInicial.prepareStatement(sql);
            statement.execute();
            JOptionPane.showMessageDialog(null, "se creo la BD " + nombreBD, "exito", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("se creo la BD " + nombreBD);
            // fin creacion de bd

        } catch (SQLException ex) {
            estado = false;
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("no se pudo conectar");
            JOptionPane.showMessageDialog(null, "no se pudo conectar o crear a bd", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

// inicio opciones solo para desarollador, se quitaran despues
    public void eliminarBd() {

        try {
            //inicio eliminacion de base de datos (NombreBD)
            String sql = "DROP DATABASE IF EXISTS " + nombreBD;
            statement = conexionInicial.prepareStatement(sql);
            statement.execute();
            System.out.println("se elimino la BD " + nombreBD);
            JOptionPane.showMessageDialog(null, "Base de Datos ELIMINADA", "aviso", JOptionPane.INFORMATION_MESSAGE);
            // fin creacion de bd

        } catch (SQLException ex) {
            Logger.getLogger(CreadorBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINARLA Base de Datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

// fin opciones solo para desarollador
    private void crearNumeroFactura(String nombreTabla) {

        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "      ID int(6) NOT NULL,"
                + "      NumFacturaFinal int(6) NOT NULL"
                + "     )";

        try {

            statement = conexionBD.prepareStatement(sql);
            statement.execute();
            System.out.println("se creo la tabla " + nombreTabla);

        } catch (SQLException ex) {
            estado = false;
            Logger.getLogger(CreadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearFactura(String nombreTabla) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "      numFacturaF int(6) NOT NULL,"
                + "      fechaF varchar(15),"
                + "      tipoMovimientoF varchar(30),"
                + "      cantidadUnidadesF int(6),"
                + "      costoUnitarioF DOUBLE(20,10),"
                + "      refOtraFacturaF int(6),"
                + "      PRIMARY KEY (numFacturaF)"
                + "     )";

        try {

            statement = conexionBD.prepareStatement(sql);
            statement.execute();
            System.out.println("se creo la tabla " + nombreTabla);

        } catch (SQLException ex) {
            estado = false;
            Logger.getLogger(CreadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearSalida(String nombreTabla) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "      numFacturaSalida int(6) NOT NULL,"
                + "      cantidadUnidadesSalida int(6),"
                + "      costoUnitarioSalida DOUBLE(20,10),"
                + "      costoTotalSalida DOUBLE(25,10),"
                + "      PRIMARY KEY (numFacturaSalida)"
                + "     )";

        try {

            statement = conexionBD.prepareStatement(sql);
            statement.execute();
            System.out.println("se creo la tabla " + nombreTabla);

        } catch (SQLException ex) {
            estado = false;
            Logger.getLogger(CreadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearEntrada(String nombreTabla) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "      numFacturaEntrada int(6) NOT NULL,"
                + "      cantidadUnidadesEntrada int(6),"
                + "      costoUnitarioEntrada DOUBLE(20,10),"
                + "      costoTotalEntrada DOUBLE(25,10),"
                + "      PRIMARY KEY (numFacturaEntrada)"
                + "     )";

        try {

            statement = conexionBD.prepareStatement(sql);
            statement.execute();
            System.out.println("se creo la tabla " + nombreTabla);

        } catch (SQLException ex) {
            estado = false;
            Logger.getLogger(CreadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearSaldo(String nombreTabla) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " ("
                + "      numFacturaSaldo int(6) NOT NULL,"
                + "      cantidadExistencias int(6),"
                + "      costoUnitarioPromedio DOUBLE(20,10),"
                + "      costoTotalSaldo DOUBLE(25,10),"
                + "      PRIMARY KEY (numFacturaSaldo)"
                + "     )";

        try {

            statement = conexionBD.prepareStatement(sql);
            statement.execute();
            System.out.println("se creo la tabla " + nombreTabla);

        } catch (SQLException ex) {
            estado = false;
            Logger.getLogger(CreadorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTablas(Connection conexionBDX) {
        conexionBD = conexionBDX;

        crearNumeroFactura("NumeroFactura");
        crearFactura("Factura");
        crearSalida("Salida");
        crearEntrada("Entrada");
        crearSaldo("Saldo");

    }

    public boolean getEstado() {
        return estado;
    }

}
