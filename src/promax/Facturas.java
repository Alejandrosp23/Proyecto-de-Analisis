/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promax;

/**
 *
 * @author aleja
 */
public class Facturas {
    
    String cantidad;
    String tipo_pago;
    String fecha;
    String id_cliente;
    String id_empleado;
    String id_producto;

    public Facturas(String cantidad, String tipo_pago, String fecha, String id_cliente, String id_empleado, String id_producto) {
        this.cantidad = cantidad;
        this.tipo_pago = tipo_pago;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_producto = id_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }
    
    
}
