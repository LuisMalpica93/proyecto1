package com.example.crudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudrest.model.Producto;
import com.example.crudrest.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
    private ProductoRepository productoRepository;

    public void crearProducto(Producto producto) {
        productoRepository.insertarProducto(producto);
    }

    public void actualizarProducto(Producto producto) {
        productoRepository.actualizarProducto(producto);
    }

    @Transactional
    public List<Producto> obtenerProductos() {
        return productoRepository.obtenerProductos();
    }
}
