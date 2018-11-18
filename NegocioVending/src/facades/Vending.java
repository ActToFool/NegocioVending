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
import facade.GestionProducto;
import facade.IGestionProducto;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emanuel Álvarez
 */
public class Vending implements IVending{

    Map<Integer, Producto> catalogo;
    IGestionProducto iGstProducto;

    public Vending() {
        catalogo = new HashMap<>();
        System.out.println("lleeee0000");
        //iGstProducto =  new GestionProducto();
        //iGstProducto.cargarProductos();

    }
    
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
        if(iGstProducto== null){
            iGstProducto = new GestionProducto();
            iGstProducto.cargarMonedas();
        }
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
