/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ~Antares~
 */
public class EoSDatos {

    private String EntradaOSalida; //para sabner que movimiento es

    //valores de Entrada o salida segun sea
    private int numFactura;
    private int cantidadUnidades;
    private double cosotoUnitario;
    private double costoTotal;

    public EoSDatos() {
    }

    public String getEntradaOSalida() {
        return EntradaOSalida;
    }

    public void setEntradaOSalida(String EntradaOSalida) {
        this.EntradaOSalida = EntradaOSalida;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int NumFactura) {
        this.numFactura = NumFactura;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int CantidadUnidades) {
        this.cantidadUnidades = CantidadUnidades;
    }

    public double getCosotoUnitario() {
        return cosotoUnitario;
    }

    public void setCosotoUnitario(double CosotoUnitario) {
        this.cosotoUnitario = CosotoUnitario;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double CostoTotal) {
        this.costoTotal = CostoTotal;
    }

}
