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
public class Saldo {

    private int numFactura;
    private int cantidadExistencias;
    private double costoUnitarioPromedio;
    private double costoTotal;

    public Saldo() {
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public int getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(int cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public double getCostoUnitarioPromedio() {
        return costoUnitarioPromedio;
    }

    public void setCostoUnitarioPromedio(double costoUnitarioPromedio) {
        this.costoUnitarioPromedio = costoUnitarioPromedio;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotalSaldo) {
        this.costoTotal = costoTotalSaldo;
    }

}
