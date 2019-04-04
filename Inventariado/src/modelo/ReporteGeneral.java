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
public class ReporteGeneral {

    private int numFactura;
    private String feha;
    private String tipoMovimiento;
    private int refOtraFactura;
    private int cantidadUnidadesFactura;
    private double costoUnitarioFactura;

    private int cantidadUnidadesEntrada;
    private double costoUnitarioEntrada;
    private double costoTotalEntrada;

    private int cantidadUnidadesSalida;
    private double costoUnitarioSalida;
    private double costoTotalSalida;

    private int cantidadExistencias;
    private double costoTotalSaldo;
    private double costoUnitarioPromedio;

    public ReporteGeneral() {
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getFeha() {
        return feha;
    }

    public void setFeha(String feha) {
        this.feha = feha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getRefOtraFactura() {
        return refOtraFactura;
    }

    public void setRefOtraFactura(int refOtraFactura) {
        this.refOtraFactura = refOtraFactura;
    }

    public int getCantidadUnidadesFactura() {
        return cantidadUnidadesFactura;
    }

    public void setCantidadUnidadesFactura(int cantidadUnidadesFactura) {
        this.cantidadUnidadesFactura = cantidadUnidadesFactura;
    }

    public double getCostoUnitarioFactura() {
        return costoUnitarioFactura;
    }

    public void setCostoUnitarioFactura(double costoUnitarioFactura) {
        this.costoUnitarioFactura = costoUnitarioFactura;
    }

    public int getCantidadUnidadesEntrada() {
        return cantidadUnidadesEntrada;
    }

    public void setCantidadUnidadesEntrada(int cantidadUnidadesEntrada) {
        this.cantidadUnidadesEntrada = cantidadUnidadesEntrada;
    }

    public double getCostoUnitarioEntrada() {
        return costoUnitarioEntrada;
    }

    public void setCostoUnitarioEntrada(double costoUnitarioEntrada) {
        this.costoUnitarioEntrada = costoUnitarioEntrada;
    }

    public double getCostoTotalEntrada() {
        return costoTotalEntrada;
    }

    public void setCostoTotalEntrada(double costoTotalEntrada) {
        this.costoTotalEntrada = costoTotalEntrada;
    }

    public int getCantidadUnidadesSalida() {
        return cantidadUnidadesSalida;
    }

    public void setCantidadUnidadesSalida(int cantidadUnidadesSalida) {
        this.cantidadUnidadesSalida = cantidadUnidadesSalida;
    }

    public double getCostoUnitarioSalida() {
        return costoUnitarioSalida;
    }

    public void setCostoUnitarioSalida(double costoUnitarioSalida) {
        this.costoUnitarioSalida = costoUnitarioSalida;
    }

    public double getCostoTotalSalida() {
        return costoTotalSalida;
    }

    public void setCostoTotalSalida(double costoTotalSalida) {
        this.costoTotalSalida = costoTotalSalida;
    }

    public int getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(int cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public double getCostoTotalSaldo() {
        return costoTotalSaldo;
    }

    public void setCostoTotalSaldo(double costoTotalSaldo) {
        this.costoTotalSaldo = costoTotalSaldo;
    }

    public double getCostoUnitarioPromedio() {
        return costoUnitarioPromedio;
    }

    public void setCostoUnitarioPromedio(double costoUnitarioPromedio) {
        this.costoUnitarioPromedio = costoUnitarioPromedio;
    }

}
