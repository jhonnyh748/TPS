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
public class Factura {

    private int numFactura;
    private String feha;
    private String tipoMovimiento;
    private int cantidadUnidades;
    private double cosotUnitario;
    private int refOtraFactura;

    public Factura() {
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

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public double getCosotUnitario() {
        return cosotUnitario;
    }

    public void setCosotUnitario(double cosotUnitario) {
        this.cosotUnitario = cosotUnitario;
    }

    public int getRefOtraFactura() {
        return refOtraFactura;
    }

    public void setRefOtraFactura(int refOtraFactura) {
        this.refOtraFactura = refOtraFactura;
    }

}
