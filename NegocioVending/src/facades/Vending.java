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
import entidades.Moneda;
import entidades.Producto;
import entidades.Venta;
import facade.GestionProducto;
import facade.IGestionProducto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emanuel Álvarez
 */
public class Vending implements IVending{

    private Map<Integer, Producto> catalogo;
    private Venta ventaActual;
    private IGestionProducto iGstProducto;
    private ArrayList<Venta> ventasRealizadas;
    private ArrayList<Moneda> dineroAcumulado;
    
    
    //Función del punto 1: Hay que codificar la funcionalidad en 'GestionProducto'
    public Vending() {
        catalogo = new HashMap<>();
        System.out.println("lleeee0000");
        iGstProducto =  new GestionProducto();
        iGstProducto.cargarProductos();

    }
    
    //Funcion del punto 3: 
    @Override
    public DTOTotal agregarLinea(Producto p_producto, int cantidad) {
        if((this.verificarExistencia(p_producto) == true) && (this.verificarUnidadesProducto(p_producto, cantidad) == true) ){
            Linea lineaPro = buscarProductoEnLinea(p_producto);
            if(lineaPro != null){
                lineaPro.agregarCantidad(cantidad);
            }
            else{
                lineaPro = new Linea(cantidad, p_producto);
                this.ventaActual.getLineas().add(lineaPro);
                ventaActual.getLineas();
            }
        }
        
        return null;
    }
    
    //Método punto 3 -- c.

    //Metodo privado que busca si el producto selecionado ya existe en una linea anterior
    private Linea buscarProductoEnLinea(Producto p_producto){
        ArrayList<Linea>lineas = this.ventaActual.getLineas();
        
        for (Linea linea : lineas) {
            if(linea.getProductoVendido().getNumero() == p_producto.getNumero()){
                return linea;
            }
        }
        
        return null;
    }
    
    //Método privado que verifica si hay unidades suficientes del producto solicitado
    private boolean verificarUnidadesProducto(Producto p_producto, int cantidad){
        Producto p_temp = catalogo.get(p_producto.getNumero());
        if(p_temp.getUnidadesDisponibles() >= cantidad ){
            return true;        //No sé si debemos restarlos de una vez
        }
        return false;
    }
    
    //Metodo que verifica si existe el producto en el catalogo
    private boolean verificarExistencia(Producto p_producto){
        if(catalogo.get(p_producto.getNumero()) != null){
            return true;
        }
        return false;
    }
    
    @Override
    public int terminarVenta() {
        return 0;
    }

    @Override
    public DTOTotal eliminarLinea(Linea p_linea) {
        return null;
    }

    
    // Funcion del punto 2: ¿se puede crear una venta temporal?
    @Override
    public boolean nuevaVenta() {
        if (this.catalogo.isEmpty()) {
            return false;
        } else {
            this.ventaActual = new Venta();
            this.ventaActual.setFechaHora(LocalDate.now());
            this.ventasRealizadas.add(this.ventaActual); //La estamos agregando al final y no al inicio
            return true;
        }
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
