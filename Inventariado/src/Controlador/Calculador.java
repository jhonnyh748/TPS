/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.EoSDatos;
import modelo.Saldo;

/**
 *
 * @author ~Antares~
 */
public class Calculador {

    private EoSDatos eosDatos;
    private Saldo saldo;

    public Calculador() {

    }

    public void calcularESySaldo(int compraOVenta, int normalODevulocion, EoSDatos eosDatosX, Saldo saldoX) {

        eosDatos = eosDatosX;
        saldo = saldoX;

        saldo.setCantidadExistencias(saldo.getCantidadExistencias() + (eosDatos.getCantidadUnidades() * compraOVenta));
        saldo.setCostoTotal(saldo.getCostoTotal() + (eosDatos.getCostoTotal() * compraOVenta));
        saldo.setCostoUnitarioPromedio(saldo.getCostoTotal() / saldo.getCantidadExistencias());

        eosDatos.setCantidadUnidades(eosDatos.getCantidadUnidades() * normalODevulocion);
        eosDatos.setCostoTotal(eosDatos.getCostoTotal() * normalODevulocion);

    }

    public EoSDatos getEosDatos() {
        return eosDatos;
    }

    public Saldo getSaldo() {
        return saldo;
    }

}
