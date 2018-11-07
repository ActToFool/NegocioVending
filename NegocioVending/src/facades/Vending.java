/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.DTOReporte;
import entidades.DTOTotal;
import entidades.Denominacion;
import entidades.Linea;
import entidades.Producto;

/**
 *
 * @author Emanuel Álvarez
 */
public class Vending implements IVending{

    @Override
    public DTOTotal agregarLinea(Producto p_producto, int cantidad) {
        return null;
    }

    @Override
    public int terminarVenta() {
        return 0;
    }

    @Override
    public DTOTotal eliminarLinea(Linea p_linea) {
        return null;
    }

    @Override
    public boolean nuevaVenta() {
        return false;
    }

    @Override
    public boolean agragarMoneda(Denominacion p_Denominacion) {
        return false;
    }

    @Override
    public DTOReporte reporteDiario() {
        return null;
    }
    
}
