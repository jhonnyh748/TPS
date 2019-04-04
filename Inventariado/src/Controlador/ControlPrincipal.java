/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConsultasBD;
import modelo.EoSDatos;
import modelo.Factura;
import modelo.ReporteGeneral;
import modelo.Saldo;
import vista.VentanaPrincipal;

/**
 *
 * @author ~Antares~
 */
public class ControlPrincipal {

    //vista
    private VentanaPrincipal ventanaPrincipal;
    //****

    //clases de datos
    private Factura factura;
    private EoSDatos eosDatos;
    private Saldo saldo;
    private ReporteGeneral reporteGeneral;
    private ArrayList<ReporteGeneral> reporteGeneralMatriz;
    //**********

    private Calculador calculador;

    private int ultimoNumeroFactura;

    private ConsultasBD consulta;

    private static final int ENTRADA = 1;
    private static final int SALIDA = -1;

    private static final int NORMAL = 1;
    private static final int DEVOLUCION = -1;

    //VentnaPrincipal ventana;
    public ControlPrincipal() {

        factura = new Factura();
        eosDatos = new EoSDatos();
        saldo = new Saldo();

        consulta = new ConsultasBD();

        generarNumFacturaInicial();
        getUltimoNumeroFactura();

        //VentanaPrincipal ventana = new VentanaPrincipal;
        //ventana.setnumeroFactura(int numeFacturaX);
    }

    //numero factura operations
    private void generarNumFacturaInicial() {
        ultimoNumeroFactura = consulta.getUltimoNumeroFactura();
        System.out.println("ultimo numero Factura Inicial -->> " + ultimoNumeroFactura);
        if (ultimoNumeroFactura == -1) {
            ultimoNumeroFactura = 999;
            consulta.setUltimoNumeroFactura(ultimoNumeroFactura);

            //inicializa el acumulador saldo
            saldo.setCantidadExistencias(0);
            saldo.setCostoTotal(0);
            saldo.setCostoUnitarioPromedio(0);
        } else {
            saldo = consulta.getSaldo();

            System.out.println("\n\n_______saldo inicial para la trnasaccion:");
            System.out.println("cant = " + saldo.getCantidadExistencias());
            System.out.println("costoTotal = " + saldo.getCostoTotal());
            System.out.println("costo Unitario Promedio = " + saldo.getCostoUnitarioPromedio());
            System.out.println("___________________\n");
        }
    }

    private void getUltimoNumeroFactura() {
        ultimoNumeroFactura = consulta.getUltimoNumeroFactura();
        ultimoNumeroFactura++;
    }

    private void guardarNumeroFactura() {
        consulta.updateUltimoNumeroFactura(ultimoNumeroFactura);
        ultimoNumeroFactura++;
    }

    public int getNumFactura() {
        return ultimoNumeroFactura;
    }
    //end numero factura operations

    private void calcularDatosYSaldo() {

        String tipoMovimiento = factura.getTipoMovimiento();

        eosDatos.setCantidadUnidades(factura.getCantidadUnidades());
        if (tipoMovimiento.equals("venta")) {
            eosDatos.setCosotoUnitario(consulta.getUltimoCostoUnitarioPromedio());
        } else {
            eosDatos.setCosotoUnitario(factura.getCosotUnitario());
        }
        eosDatos.setCostoTotal(eosDatos.getCantidadUnidades() * eosDatos.getCosotoUnitario());

        calculador = new Calculador();

        switch (tipoMovimiento) {

            case "compra":
                calculador.calcularESySaldo(ENTRADA, NORMAL, eosDatos, saldo);
                break;

            case "venta":
                calculador.calcularESySaldo(SALIDA, NORMAL, eosDatos, saldo);
                break;

            case "devolucion Compra":
                //debo pedir antes el costo de la referencia de la factura antigua
                calculador.calcularESySaldo(SALIDA, DEVOLUCION, eosDatos, saldo);
                break;

            case "devolucion Venta":
                //debo pedir antes el costo de la referencia de la factura antigua
                calculador.calcularESySaldo(ENTRADA, DEVOLUCION, eosDatos, saldo);
                break;
        }
        eosDatos = calculador.getEosDatos();
        saldo = calculador.getSaldo();

    }

    private boolean guardarEntradaOSalida() {
        boolean respuesta = true;
        String tipoMovimiento = factura.getTipoMovimiento();
        switch (tipoMovimiento) {

            case "compra":
            case "devolucion Compra":
                respuesta = consulta.guardarEntradaOSalida(ENTRADA, eosDatos);
                break;

            case "venta":
            case "devolucion Venta":
                respuesta = consulta.guardarEntradaOSalida(SALIDA, eosDatos);
                break;
        }
        return respuesta;
    }

    private void asignarNumFacturas() {
        eosDatos.setNumFactura(factura.getNumFactura());
        saldo.setNumFactura(factura.getNumFactura());
    }

    public Double getPrecioUnidad(int refOtraFactura, String tipoMovimiento) {
        return consulta.getPrecioUnidad(refOtraFactura, tipoMovimiento);
    }

    public ArrayList<ReporteGeneral> getReporteGeneral() {
        return consulta.getReporteGeneral();
    }

    public boolean hacerTransaccionPrincipal(Factura facturaPruebas) {

        boolean paso1;
        boolean paso2;
        boolean paso3;
        boolean respuesta = true;

        System.out.println("\n_______________ inicio movimiento _______________\n");

        factura = facturaPruebas;

        calcularDatosYSaldo();              //hace operaciones de inventario

        asignarNumFacturas();               //da el numFactura a eosDatos y a saldo

        paso1 = consulta.guardarFactura(factura);   //inserta factura en BD
        paso2 = guardarEntradaOSalida();            //inserta Entrada o salida e BD
        paso3 = consulta.guardarSaldo(saldo);       //inserta saldo en BD

        if (paso1 && paso2 && paso3) {
            guardarNumeroFactura();
            imprimirReporteGeneral();
        } else {
            respuesta = false;
        }

        //genera un nuevo numero de factura
        System.out.println("");
        System.out.println("cantidad unidades ->" + eosDatos.getCantidadUnidades() + " costo unitario ->" + eosDatos.getCosotoUnitario() + " costo total->" + eosDatos.getCostoTotal());
        System.out.println("saldo cantidad existencias " + saldo.getCantidadExistencias() + " cosoto total " + saldo.getCostoTotal() + "saldo costo unitario promedio " + saldo.getCostoUnitarioPromedio());

        System.out.println("\n______________________________________________\n");
        return respuesta;

    }

    public ArrayList<ReporteGeneral> imprimirReporteGeneral() {
        reporteGeneralMatriz = consulta.getReporteGeneral();

        for (int i = 0; i < reporteGeneralMatriz.size(); i++) {
            reporteGeneral = reporteGeneralMatriz.get(i);

            System.out.print(reporteGeneral.getNumFactura() + "   |  ");
            System.out.print(reporteGeneral.getFeha() + "   |  ");
            System.out.print(reporteGeneral.getTipoMovimiento() + "   |  ");

            System.out.print(reporteGeneral.getRefOtraFactura() + "   |  ");
            System.out.print(reporteGeneral.getCantidadUnidadesFactura() + "   |  ");
            System.out.print(reporteGeneral.getCostoUnitarioFactura() + "   |  ");

            System.out.print(reporteGeneral.getCantidadUnidadesEntrada() + "   |  ");
            System.out.print(reporteGeneral.getCostoUnitarioEntrada() + "   |  ");
            System.out.print(reporteGeneral.getCostoTotalEntrada() + "   |  ");

            System.out.print(reporteGeneral.getCantidadUnidadesSalida() + "   |  ");
            System.out.print(reporteGeneral.getCostoUnitarioSalida() + "   |  ");
            System.out.print(reporteGeneral.getCostoTotalSalida() + "   |  ");

            System.out.print(reporteGeneral.getCantidadExistencias() + "   |  ");
            System.out.print(reporteGeneral.getCostoTotalSaldo() + "   |  ");
            System.out.print(reporteGeneral.getCostoUnitarioPromedio() + "   |  ");

            System.out.println("");

        }
        return reporteGeneralMatriz;
    }

}
