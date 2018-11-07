/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.DTOReporte;
import entidades.DTOTotal;
import entidades.Denominacion;
import entidades.Producto;
import entidades.Linea;

/**
 *
 * @author Emanuel Álvarez
 */
public interface IVending {
    
    DTOTotal agregarLinea(Producto p_producto, int cantidad);
    int terminarVenta();
    DTOTotal eliminarLinea(Linea p_linea);
    boolean nuevaVenta();
    boolean agragarMoneda(Denominacion p_Denominacion);
    DTOReporte reporteDiario();
    
}
