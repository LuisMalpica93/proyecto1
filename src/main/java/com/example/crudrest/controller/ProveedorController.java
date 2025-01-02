package com.example.crudrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrest.model.Proveedor;
import com.example.crudrest.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorService.crearProveedor(proveedor);
            Map<String, Object> response = new HashMap<>();
            response.put("codigo", 200);
            response.put("mensaje", "Proveedor creado exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("codigo", 500);
            errorResponse.put("mensaje", "Error al crear el proveedor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarProveedor(@RequestBody Proveedor proveedor) {
        try {
            proveedorService.actualizarProveedor(proveedor);
            Map<String, Object> response = new HashMap<>();
            response.put("codigo", 200);
            response.put("mensaje", "Proveedor actualizado exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("codigo", 500);
            errorResponse.put("mensaje", "Error al actualizar el proveedor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    
    @GetMapping("/listar")
    public List<Proveedor> obtenerProveedores() {
        return proveedorService.obtenerProveedores();
    }
}