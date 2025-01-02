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

import com.example.crudrest.model.Producto;
import com.example.crudrest.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearProducto(@RequestBody Producto producto) {
        try {
            productoService.crearProducto(producto);
            Map<String, Object> response = new HashMap<>();
            response.put("codigo", 200);
            response.put("mensaje", "Producto creado exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("codigo", 500);
            errorResponse.put("mensaje", "Error al crear el producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizarProducto(@RequestBody Producto producto) {
        try {
            productoService.actualizarProducto(producto);
            Map<String, Object> response = new HashMap<>();
            response.put("codigo", 200);
            response.put("mensaje", "Producto actualizado exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("codigo", 500);
            errorResponse.put("mensaje", "Error al actualizar el producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    
    @GetMapping("/listar")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }
}