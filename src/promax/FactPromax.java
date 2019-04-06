/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promax;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aleja
 */
public class FactPromax {
    
    //<editor-fold defaultstate="collapsed" desc="Variables y Getters&Setters">
    static String perfil;
    static int id_usuario;

    public static String getPerfil() {
        return perfil;
    }

    public static void setPerfil(String perfil) {
        FactPromax.perfil = perfil;
    }

    public static int getId_usuario() {
        return id_usuario;
    }

    public static void setId_usuario(int id_usuario) {
        FactPromax.id_usuario = id_usuario;
    }
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Conexion JDBC">
    //CLASE PARA EJECUTAR LA CONEXION DE BD
    public static Conexion conex = new Conexion();
    Connection conn;
    Statement st;

    public void conectar(){
        //IMPEMENTACION DE LOS METODOS DE CONEXION
        try{
            conn = conex.conexion();
            st = conn.createStatement();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR SQL" + ex);
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento Clientes">
    public static void guardarCliente(Clientes clientes){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = clientes.getNombre();
            String apellido = clientes.getApellido();
            String telefono = clientes.getTelefono();
            String direccion = clientes.getDireccion();
            String email = clientes.getEmail();
            String sexo = clientes.getSexo();
            
            st.executeQuery("insert into clientes values('"+ nombre +"','"+ apellido +"','"+ telefono +"','"+ direccion +"','"+ email +"','"+ sexo +"');");
        }catch(SQLException ex){
            System.out.println(ex);
        }
        }
    
    public static void modificarCliente(Clientes clientes, String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = clientes.getNombre();
            String apellido = clientes.getApellido();
            String telefono = clientes.getTelefono();
            String direccion = clientes.getDireccion();
            String email = clientes.getEmail();
            String sexo = clientes.getSexo();
            
            st.executeQuery("update clientes set nombre='"+ nombre +"', apellido='"+ apellido +"', telefono='"+ telefono +
                    "', direccion='"+ direccion +"', email='"+ email +"', sexo='"+ sexo +"' where id_cliente= '"+id +"';");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void eliminarCliente(String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            st.executeQuery("delete from clientes where id_cliente ="+id +";");
        }catch(SQLException ex){
            System.out.println(ex);;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento Empleados">
    public static void guardarEmpleado(Empleados empleados){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = empleados.getNombre();
            String apellido = empleados.getApellido();
            String telefono = empleados.getTelefono();
            String cargo = empleados.getCargo();
            String salario = empleados.getSueldo();
            String direccion = empleados.getDireccion();
            String email = empleados.getEmail();
            String sexo = empleados.getSexo();
            
            st.executeQuery("insert into empleados values('"+ nombre +"','"+ apellido +"','"+ telefono +"','"+ cargo +"',"+ salario +",'"+ direccion +"','"+ email +"','"+ sexo +"');");
        }catch(SQLException ex){
            System.out.println(ex);
        }
        }
    
    public static void modificarEmpleado(Empleados empleados, String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = empleados.getNombre();
            String apellido = empleados.getApellido();
            String telefono = empleados.getTelefono();
            String cargo = empleados.getCargo();
            String salario = empleados.getSueldo();
            String direccion = empleados.getDireccion();
            String email = empleados.getEmail();
            String sexo = empleados.getSexo();
            
            st.executeQuery("update empleados set nombre='"+ nombre +"', apellido='"+ apellido +"', telefono='"+ telefono +
                    "', cargo='"+ cargo +"', salario="+ salario +", direccion='"+ direccion +"', email='"+ email +"', sexo='"+ sexo +
                    "' where id_empleado= '"+id +"';");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void eliminarEmpleado(String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            st.executeQuery("delete from empleados where id_empleado ="+id +";");
        }catch(SQLException ex){
            System.out.println(ex);;
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento Productos">
    public static void guardarProducto(Producto producto){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = producto.getNombre();
            String precio = producto.getPrecio();
            String cantidad = producto.getCantidad();
            String descripcion = producto.getDescripcion();
            String id_proveedor = producto.getId_proveedor();
            
            
            st.executeQuery("insert into productos values('"+ nombre +"',"+ precio +","+ cantidad +",'"+ descripcion +"',"+ id_proveedor +");");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void modificarProducto(Producto producto, String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = producto.getNombre();
            String precio = producto.getPrecio();
            String cantidad = producto.getCantidad();
            String descripcion = producto.getDescripcion();
            String id_proveedor = producto.getId_proveedor();
            
            st.executeQuery("update productos set nombre='"+ nombre +"', precio="+ precio +", cantidad="+ cantidad +
                    ", descripcion='"+ descripcion +"', fk_id_proveedor="+ id_proveedor +" where id_producto= "+id +";");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void eliminarProducto(String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            st.executeQuery("delete from productos where id_producto ="+id +";");
        }catch(SQLException ex){
            System.out.println(ex);;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento Proveedor">
    public static void guardarProveedor(Proveedor proveedor){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = proveedor.getNombre();
            String apellido = proveedor.getApellido();
            String telefono = proveedor.getTelefono();
            String empresa = proveedor.getEmpresa();
            String email = proveedor.getEmail();
            
            
            st.executeQuery("insert into proveedor values('"+ nombre +"','"+ apellido +"','"+ telefono +"','"+ empresa +"','"+ email +"');");
        }catch(SQLException ex){
            System.out.println(ex);
        }
        }
    
    public static void modificarProveedor(Proveedor proveedor, String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String nombre = proveedor.getNombre();
            String apellido = proveedor.getApellido();
            String telefono = proveedor.getTelefono();
            String empresa = proveedor.getEmpresa();
            String email = proveedor.getEmail();
            
            st.executeQuery("update proveedor set nombre='"+ nombre +"', apellido='"+ apellido +"', telefono='"+ telefono +
                    "', empresa='"+ empresa +"', email='"+ email +"' where id_proveedor= "+id +";");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void eliminarProveedor(String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            st.executeQuery("delete from proveedor where id_proveedor ="+id +";");
        }catch(SQLException ex){
            System.out.println(ex);;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento Facturas">
    public static void guardarFactura(Facturas factura){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String cantidad = factura.getCantidad();
            String tipo_pago = factura.getTipo_pago();
            String fecha = factura.getFecha();
            String id_cliente = factura.getId_cliente();
            String id_empleado = factura.getId_empleado();
            String id_producto = factura.getId_producto();
            
            st.executeQuery("insert into facturas values("+ cantidad +",'"+ tipo_pago +"','"+ fecha +"',"+ id_cliente +","+ id_empleado +","+ id_producto +");");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void modificarFactura(Facturas factura, String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String cantidad = factura.getCantidad();
            String tipo_pago = factura.getTipo_pago();
            String fecha = factura.getFecha();
            String id_cliente = factura.getId_cliente();
            String id_empleado = factura.getId_empleado();
            String id_producto = factura.getId_producto();
            
            st.executeQuery("update facturas set cantidad="+ cantidad +", tipo_pago='"+ tipo_pago +"', fecha='"+ fecha +
                    "', fk_id_cliente="+ id_cliente +", fk_id_empleado="+ id_empleado +", fk_id_producto="+ id_producto +
                    " where id_factura= "+id +";");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void eliminarFactura(String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            st.executeQuery("delete from facturas where id_factura ="+id +";");
        }catch(SQLException ex){
            System.out.println(ex);;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento Usarios">
    public static void guardarUsuario(Usuario usuarios){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String usuario = usuarios.getUsuario();
            String contrasena = usuarios.getContrasena();
            String perfil = usuarios.getPerfil();
            String id_empleado = usuarios.getId_empleado();
            
            st.executeQuery("insert into usuarios values('"+ usuario +"','"+ contrasena +"','"+ perfil +"',"+ id_empleado +");");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void modificarUsuario(Usuario usuarios, String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            String usuario = usuarios.getUsuario();
            String contrasena = usuarios.getContrasena();
            String perfil = usuarios.getPerfil();
            String id_empleado = usuarios.getId_empleado();
            
            st.executeQuery("update usuarios set usuario='"+ usuario +"', contrasena='"+ contrasena +"', perfil='"+ perfil +
                    "', fk_id_empleado="+ id_empleado +" where id_usuario= "+id +";");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void eliminarUsuario(String id){
        try{
            Statement st;
            st = conex.conexion().createStatement();
            
            st.executeQuery("delete from usuarios where id_usuario ="+id +";");
        }catch(SQLException ex){
            System.out.println(ex);;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Queries">
    public static void consultaCliente(String valor, String cbo, JTable tblClientes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("Select * from clientes where "+cbo+" like '%"+valor+"%';");
        
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[7];

            fila[0] = rs.getString("id_cliente");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("apellido");
            fila[3] = rs.getString("telefono");
            fila[4] = rs.getString("direccion");
            fila[5] = rs.getString("email");
            fila[6] = rs.getString("sexo");
            
            model.addRow(fila);
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void consultaEmpleado(String valor, String cbo, JTable tblEmpleado){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("Select * from empleados where "+cbo+" like '%"+valor+"%';");
        
        DefaultTableModel model = (DefaultTableModel) tblEmpleado.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[9];

            fila[0] = rs.getString("id_empleado");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("apellido");
            fila[3] = rs.getString("telefono");
            fila[4] = rs.getString("cargo");
            fila[5] = rs.getString("salario");
            fila[6] = rs.getString("direccion");
            fila[7] = rs.getString("email");
            fila[8] = rs.getString("sexo");
            
            model.addRow(fila);
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void consultaInventario(String valor, String cbo, JTable tblProductos){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("Select * from productos where "+cbo+" like '%"+valor+"%';");
        
        DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[6];

            fila[0] = rs.getString("id_producto");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("precio");
            fila[3] = rs.getString("cantidad");
            fila[4] = rs.getString("descripcion");
            fila[5] = rs.getString("fk_id_proveedor");
            
            model.addRow(fila);
        }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void consultaProveedor(String valor, String cbo, JTable tblProveedor){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("Select * from proveedor where "+cbo+" like '%"+valor+"%';");
        
        DefaultTableModel model = (DefaultTableModel) tblProveedor.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[6];

            fila[0] = rs.getString("id_proveedor");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("apellido");
            fila[3] = rs.getString("telefono");
            fila[4] = rs.getString("empresa");
            fila[5] = rs.getString("email");
            
            model.addRow(fila);
        }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void consultaFactura(String valor, String cbo, JTable tblFactura){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select f.id_factura, \n" +
                                       "c.nombre 'cliente',\n" +
                                       "e.nombre 'empleado',\n" +
                                       "p.nombre 'producto',\n" +
                                       "f.cantidad,\n" +
                                       "p.precio,\n" +
                                       "(p.precio*f.cantidad) 'total',\n" +
                                       "f.tipo_pago,\n" +
                                       "convert(varchar(10), f.fecha, 101) 'fecha'\n" +
                                       "from facturas f\n" +
                                       "join clientes c\n" +
                                       "on f.fk_id_cliente = c.id_cliente\n" +
                                       "join empleados e\n" +
                                       "on f.fk_id_empleado = e.id_empleado\n" +
                                       "join productos p\n" +
                                       "on f.fk_id_producto = p.id_producto\n" +
                                       " where "+cbo+" like '%"+valor+"%';");
        
        DefaultTableModel model = (DefaultTableModel) tblFactura.getModel();
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[9];

            fila[0] = rs.getString("id_factura");
            fila[1] = rs.getString("cliente");
            fila[2] = rs.getString("empleado");
            fila[3] = rs.getString("producto");
            fila[4] = rs.getString("cantidad");
            fila[5] = rs.getString("precio");
            fila[6] = rs.getString("total");
            fila[7] = rs.getString("tipo_pago");
            fila[8] = rs.getString("fecha");
            
            model.addRow(fila);
        }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Reportes">
    public static void productoMes(JTable tblReportes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select distinct year(f.fecha) as 'año',\n" +
                                       "datename(month, f.fecha) as 'mes',\n" +
                                       "p.nombre,\n" +
                                       "f.fk_id_producto\n" +
                                       "from facturas f\n" +
                                       "join productos p\n" +
                                       "on f.fk_id_producto = p.id_producto\n" +
                                       "group by datepart(month, f.fecha),\n" +
                                       "f.fk_id_producto,\n" +
                                       "p.nombre,\n" +
                                       "f.fecha;");
        
        String [] columnas = {"año", "mes","producto","id"};
        
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model = new DefaultTableModel(null,columnas);
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[4];

            fila[0] = rs.getString("año");
            fila[1] = rs.getString("mes");
            fila[2] = rs.getString("nombre");
            fila[3] = rs.getString("fk_id_producto");
            
            model.addRow(fila);
        }
        tblReportes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void masVendido(JTable tblReportes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select p.nombre as 'producto',\n" +
"	   datename(month, f.fecha) as 'mes',\n" +
"	   year(f.fecha) as 'año',\n" +
"	   f.cantidad\n" +
"from facturas f\n" +
"join productos p\n" +
"on f.fk_id_producto = p.id_producto\n" +
"group by datename(month, f.fecha),\n" +
"		 year(f.fecha),\n" +
"		 f.cantidad,\n" +
"		 p.nombre\n" +
"having max(f.cantidad)\n" +
"= (select max(cantidad)\n" +
"from facturas);");
        
        String [] columnas = {"producto", "mes","año","cantidad"};
        
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model = new DefaultTableModel(null,columnas);
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[4];

            fila[0] = rs.getString("producto");
            fila[1] = rs.getString("mes");
            fila[2] = rs.getString("año");
            fila[3] = rs.getString("cantidad");
            
            model.addRow(fila);
        }
        tblReportes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void gananciasHoy(JTable tblReportes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select sum(f.cantidad*p.precio) as 'total de ventas',\n" +
"	   convert(varchar(10), f.fecha, 103) 'fecha actual'\n" +
"from facturas f\n" +
"join productos p\n" +
"on f.fk_id_producto = p.id_producto\n" +
"where f.fecha = convert(date, getdate())\n" +
"group by f.fecha;");
        
        String [] columnas = {"total de ventas", "fecha actual"};
        
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model = new DefaultTableModel(null,columnas);
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[2];

            fila[0] = rs.getString("total de ventas");
            fila[1] = rs.getString("fecha actual");
            
            model.addRow(fila);
        }
        tblReportes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void gananciasMensual(JTable tblReportes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select sum(f.cantidad*p.precio) as 'total de ventas',\n" +
"	   datename(month, f.fecha) as 'mes',\n" +
"	   year(f.fecha) as 'año'\n" +
"from facturas f\n" +
"join productos p\n" +
"on f.fk_id_producto = p.id_producto\n" +
"group by datename(month, f.fecha),\n" +
"		 year(f.fecha);");
        
        String [] columnas = {"total de ventas", "mes","año"};
        
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model = new DefaultTableModel(null,columnas);
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[3];

            fila[0] = rs.getString("total de ventas");
            fila[1] = rs.getString("mes");
            fila[2] = rs.getString("año");
            
            model.addRow(fila);
        }
        tblReportes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void clientesHoy(JTable tblReportes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select count(fk_id_cliente) as 'cantidad clientes',\n" +
"	   convert(varchar(10), fecha, 103) 'fecha actual'\n" +
"from facturas\n" +
"where fecha = convert(date, getdate())\n" +
"group by fecha;");
        
        String [] columnas = {"cantidad clientes", "fecha actual"};
        
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model = new DefaultTableModel(null,columnas);
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[3];

            fila[0] = rs.getString("cantidad clientes");
            fila[1] = rs.getString("fecha actual");
            
            model.addRow(fila);
        }
        tblReportes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void clientesMensual(JTable tblReportes){
        try {
        Statement st = FactPromax.conex.conexion().createStatement();
        
        ResultSet rs = st.executeQuery("select count(fk_id_cliente) as 'cantidad clientes',\n" +
"	   datename(month, fecha) as 'mes',\n" +
"	   year(fecha) as 'año'\n" +
"from facturas\n" +
"group by datename(month, fecha),\n" +
"		 year(fecha);");
        
        String [] columnas = {"cantidad clientes", "mes","año"};
        
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model = new DefaultTableModel(null,columnas);
        while(model.getRowCount()>0)model.removeRow(0);
        
        while (rs.next()) {
            Object[] fila = new Object[3];

            fila[0] = rs.getString("cantidad clientes");
            fila[1] = rs.getString("mes");
            fila[2] = rs.getString("año");
            
            model.addRow(fila);
        }
        tblReportes.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    //</editor-fold>
    
}
