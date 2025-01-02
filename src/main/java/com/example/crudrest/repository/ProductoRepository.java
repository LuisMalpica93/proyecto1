package com.example.crudrest.repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.crudrest.model.Producto;

@Repository
public class ProductoRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertarProducto(Producto producto) {
        String sql = "CALL comercio.sp_insertar_producto(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, producto.getNombre(), producto.getDetalle(), producto.getCodigo(), producto.getPrecio(), producto.getProveedor_id());
    }

    public void actualizarProducto(Producto producto) {
        String sql = "CALL comercio.sp_modificar_producto(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, producto.getId(), producto.getNombre(), producto.getDetalle(), producto.getCodigo(), producto.getPrecio(), producto.getProveedor_id());
    }

    public List<Producto> obtenerProductos() {
    	String sql = "CALL comercio.sp_consultar_productos(?)";

        return jdbcTemplate.execute(sql, (CallableStatement cs) -> {
            // Registrar el parámetro de salida (el cursor)
            cs.registerOutParameter(1, Types.OTHER);
            cs.execute();

            // Obtener el cursor y transformarlo en un ResultSet
            ResultSet rs = (ResultSet) cs.getObject(1);
            List<Producto> productos = new ArrayList<>();

            // Recorrer el ResultSet y mapear los resultados a objetos Producto
            while (rs.next()) {
                productos.add(new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("detalle"),
                    rs.getString("codigo"),
                    rs.getDouble("precio"),
                    rs.getInt("proveedor_id")
                ));
            }
            return productos;
        });
    }

}
