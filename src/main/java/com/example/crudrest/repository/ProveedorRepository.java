package com.example.crudrest.repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.crudrest.model.Proveedor;

@Repository
public class ProveedorRepository {
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertarProveedor(Proveedor proveedor) {
        String sql = "CALL comercio.sp_insertar_proveedor(?, ?, ?, ?)";
        jdbcTemplate.update(sql, proveedor.getNombre(), proveedor.getDetalle(), proveedor.getRfc(), proveedor.getTelefono());
    }

    public void actualizarProveedor(Proveedor proveedor){
        String sql = "CALL comercio.sp_modificar_proveedor(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, proveedor.getId(), proveedor.getNombre(), proveedor.getDetalle(), proveedor.getRfc(), proveedor.getTelefono());
    }

    public List<Proveedor> obtenerProveedores() {
        String sql = "CALL comercio.sp_consultar_proveedores(?)";

        return jdbcTemplate.execute(sql, (CallableStatement cs) -> {
            // Registra el parámetro OUT refcursor
            cs.registerOutParameter(1, Types.REF_CURSOR);
           
            cs.execute();

            // Recupera el cursor que contiene los resultados
            ResultSet rs = (ResultSet) cs.getObject(1);
            List<Proveedor> proveedores = new ArrayList<>();

            // Itera sobre el ResultSet y mapea los datos a los objetos Proveedor
            while (rs.next()) {
                proveedores.add(new Proveedor(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("detalle"),
                    rs.getString("rfc"),
                    rs.getString("telefono")
                ));
            }
            return proveedores;
        });
    }
}
