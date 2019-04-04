/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
//import java.sql.Date;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ~Antares~
 */
public class ConsultasBD {

    private Connection con;
    private Conexion conexion;
    private PreparedStatement statement;
    private ResultSet result;

    //clases datos
    private Factura factura;
    private EoSDatos eosDatos;
    private Saldo saldo;
    private ReporteGeneral reporteGeneral;
    //**********

    public ConsultasBD() {
        conexion = new Conexion();
    }

    public boolean guardarFactura(Factura facturaX) {
        boolean respuesta = true;

        String tabla = "factura";

        String sql = ""
                + "INSERT INTO " + tabla + " VALUES ('"
                + facturaX.getNumFactura() + "', '"
                + facturaX.getFeha() + "', '"
                + facturaX.getTipoMovimiento() + "', '"
                + facturaX.getCantidadUnidades() + "', '"
                + facturaX.getCosotUnitario() + "', '"
                + facturaX.getRefOtraFactura() + "')";
        try {
            //llenar
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            statement.execute();
            System.out.println("se insertaron los datos en " + tabla);
            conexion.desconectar();
            // fin llenar
        } catch (SQLException e) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
            System.out.println("No se insertaron los datos en " + tabla);
            respuesta = false;

            if (e.getMessage().contains("Duplicate entry")) {
                System.out.println(tabla + "  ya existe");
            }
        }

        return respuesta;

    }

    public boolean guardarEntradaOSalida(int EoS, EoSDatos eosDatosX) {
        boolean respuesta = true;

        String tabla;
        if (EoS == 1) {
            tabla = "entrada";
        } else {
            tabla = "salida";
        }
        String sql = ""
                + "INSERT INTO " + tabla + " VALUES ('"
                + eosDatosX.getNumFactura() + "', '"
                + eosDatosX.getCantidadUnidades() + "', '"
                + eosDatosX.getCosotoUnitario() + "', '"
                + eosDatosX.getCostoTotal() + "')";
        try {
            //llenar"
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            statement.execute();
            System.out.println("se insertaron los datos en " + tabla);
            conexion.desconectar();
            // fin llenar
        } catch (SQLException e) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
            System.out.println("No se insertaron los datos en " + tabla);
            respuesta = false;

            if (e.getMessage().contains("Duplicate entry")) {
                System.out.println(tabla + "  ya existe");
            }
        }
        return respuesta;
    }

    public boolean guardarSaldo(Saldo saldoX) {
        boolean respuesta = true;

        String tabla = "saldo";

        String sql = ""
                + "INSERT INTO " + tabla + " VALUES ('"
                + saldoX.getNumFactura() + "', '"
                + saldoX.getCantidadExistencias() + "', '"
                + saldoX.getCostoUnitarioPromedio() + "', '"
                + saldoX.getCostoTotal() + "')";
        try {
            //llenar"
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            statement.execute();
            System.out.println("se insertaron los datos en " + tabla);
            conexion.desconectar();
            // fin llenar
        } catch (SQLException e) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
            System.out.println("No se insertaron los datos en " + tabla);
            respuesta = false;

            if (e.getMessage().contains("Duplicate entry")) {
                System.out.println(tabla + " ya existe");
            }
        }
        return respuesta;
    }

    //numero factura operations
    public void setUltimoNumeroFactura(int numFacturaX) {

        String tabla = "numeroFactura";
        String sql = ""
                + "INSERT INTO " + tabla + " VALUES ('"
                + "1" + "', '"
                + numFacturaX + "')";
        try {
            //llenar"
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            statement.execute();
            System.out.println("se insertaron los datos en " + tabla);
            conexion.desconectar();
            // fin llenar
        } catch (SQLException e) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
            System.out.println("No se insertaron los datos en " + tabla);

            if (e.getMessage().contains("Duplicate entry")) {
                System.out.println("ultimoNumfactura ya existe");
            }
        }
    }

    public void updateUltimoNumeroFactura(int numFacturaX) {

        String tabla = "numeroFactura";
        String sql = "UPDATE " + tabla + " SET NumFacturaFinal = '" + numFacturaX + "' WHERE ID = '" + 1 + "'";

        try {
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            statement.execute();
            System.out.println("se Actualizaron los datos en " + tabla);
            conexion.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se conecto");
            System.out.println("error updateUltimoNumeroFactura() " + e);
        }
    }

    public int getUltimoNumeroFactura() {

        String tabla = "numeroFactura";
        int numFacturaX = -1;
        String sql = "SELECT * FROM " + tabla;

        try {
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            result = (ResultSet) statement.executeQuery();

            while (result.next()) {
                numFacturaX = Integer.parseInt(result.getString("NumFacturaFinal"));
                System.out.println("numero factura final: " + numFacturaX);
            }
            conexion.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se conecto");
            System.out.println("error getUltimoNumeroFactura() " + e);
        }

        return numFacturaX;
    }
    //end numero factura operations

    public Saldo getSaldo() {
        String tabla = "saldo";
        String columna = "numFacturaSaldo";
        saldo = new Saldo();

        String sql = "SELECT * FROM " + tabla + " ORDER BY " + columna + " desc limit 1";

        try {
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            result = (ResultSet) statement.executeQuery();

            while (result.next()) {
                saldo.setCantidadExistencias(Integer.parseInt(result.getString("cantidadExistencias")));
                saldo.setCostoTotal(Double.parseDouble(result.getString("costoTotalSaldo")));
                saldo.setCostoUnitarioPromedio(Double.parseDouble(result.getString("costoUnitarioPromedio")));

            }
            conexion.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se conecto");
            System.out.println("error getSaldo() " + e);
        }

        return saldo;
    }

    public Double getUltimoCostoUnitarioPromedio() {
        String tabla = "saldo";
        String columnaID = "numFacturaSaldo";
        String columnaValor = "costoUnitarioPromedio";

        Double resultado = 0.0;

        String sql = "SELECT " + columnaValor + " FROM " + tabla + " ORDER BY " + columnaID + " desc limit 1";

        try {
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            result = (ResultSet) statement.executeQuery();

            while (result.next()) {
                resultado = Double.parseDouble(result.getString(1));
            }
            conexion.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se conecto");
            System.out.println("error getUltimoCostoUnitarioPromedio() " + e);
        }

        return resultado;
    }

    public Double getPrecioUnidad(int refOtraFactura, String tipoMovimiento) {

        String tabla = "";
        String columna = "";
        String ID = "";
        Double resultado = 0.0;

        switch (tipoMovimiento) {

            case "devolucion Compra":
                columna = "costoUnitarioEntrada";
                tabla = "entrada";
                ID = "numFacturaEntrada ";
                break;

            case "devolucion Venta":
                columna = "costoUnitarioSalida";
                tabla = "salida";
                ID = "numFacturaSalida";
                break;
        }

        String sql = "SELECT " + columna + " FROM " + tabla + " WHERE " + ID + " = " + refOtraFactura;

        try {
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            result = (ResultSet) statement.executeQuery();

            while (result.next()) {
                resultado = Double.parseDouble(result.getString(1));
                System.out.println("Resultado en getPrecioUnidad resultado --->>> " + resultado);
                System.out.println("Resultado en getPrecioUnidad --->>> result.getString(1)" + result.getString(1));

            }
            conexion.desconectar();

        } catch (SQLException e) {
            System.out.println("error getPrecioUnidad() " + e);
        }

        if (resultado == 0) {
            JOptionPane.showMessageDialog(null, "Factura no exite en los registros de " + tabla.toUpperCase() + ","
                    + " por favor verifique y vuelva a intentar", "Información", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    public ArrayList<ReporteGeneral> getReporteGeneral() {

        ArrayList<ReporteGeneral> reporteMatriz = new ArrayList<>();

        String sql = "SELECT  "
                + "numFacturaF, fechaF,  tipoMovimientoF,  refOtraFacturaF, cantidadUnidadesF, costoUnitarioF, "
                + "cantidadUnidadesEntrada, costoUnitarioEntrada, costoTotalEntrada, "
                + "cantidadunidadesSalida, costoUnitarioSalida, costoTotalSalida, "
                + " cantidadExistencias, costoTotalSaldo, costoUnitarioPromedio "
                + "FROM factura  "
                + "LEFT JOIN entrada  ON numFacturaF = numFacturaEntrada  "
                + "LEFT JOIN salida ON numFacturaF = numFacturaSalida LEFT JOIN saldo on numFacturaF = numFacturasaldo";

        try {
            con = conexion.getConexionInicial();
            statement = con.prepareStatement(sql);
            result = (ResultSet) statement.executeQuery();

            while (result.next()) {
                String X = "";
                reporteGeneral = new ReporteGeneral();

                reporteGeneral.setNumFactura(Integer.parseInt(result.getString("numfacturaF")));
                reporteGeneral.setFeha(result.getString("fechaF"));
                reporteGeneral.setTipoMovimiento(result.getString("tipoMovimientoF"));
                reporteGeneral.setRefOtraFactura(Integer.parseInt(result.getString("refOtraFacturaF")));
                reporteGeneral.setCantidadUnidadesFactura(Integer.parseInt(result.getString("cantidadUnidadesF")));
                reporteGeneral.setCostoUnitarioFactura(Double.parseDouble(result.getString("costoUnitarioF")));

                X = (result.getString("cantidadUnidadesEntrada") == null) ? "0" : result.getString("cantidadUnidadesEntrada");
                reporteGeneral.setCantidadUnidadesEntrada(Integer.parseInt(X));

                X = (result.getString("costoUnitarioEntrada") == null) ? "0" : result.getString("costoUnitarioEntrada");
                reporteGeneral.setCostoUnitarioEntrada(Double.parseDouble(X));

                X = (result.getString("costoTotalEntrada") == null) ? "0" : result.getString("costoTotalEntrada");
                reporteGeneral.setCostoTotalEntrada(Double.parseDouble(X));

                //
                X = (result.getString("cantidadUnidadesSalida") == null) ? "0" : result.getString("cantidadUnidadesSalida");
                reporteGeneral.setCantidadUnidadesSalida(Integer.parseInt(X));

                X = (result.getString("costoUnitarioSalida") == null) ? "0" : result.getString("costoUnitarioSalida");
                reporteGeneral.setCostoUnitarioSalida(Double.parseDouble(X));

                X = (result.getString("costoTotalSalida") == null) ? "0" : result.getString("costoTotalSalida");
                reporteGeneral.setCostoTotalSalida(Double.parseDouble(X));

                reporteGeneral.setCantidadExistencias(Integer.parseInt(result.getString("cantidadExistencias")));
                reporteGeneral.setCostoTotalSaldo(Double.parseDouble(result.getString("costoTotalSaldo")));
                reporteGeneral.setCostoUnitarioPromedio(Double.parseDouble(result.getString("costoUnitarioPromedio")));

                reporteMatriz.add(reporteGeneral);
            }
            conexion.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se conecto");
            System.out.println("error getReporteGeneral() " + e);
        }

        return reporteMatriz;
    }

}
