package com.example.crudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudrest.model.Proveedor;
import com.example.crudrest.repository.ProveedorRepository;

@Service
public class ProveedorService {
	@Autowired
    private ProveedorRepository proveedorRepository;

    public void crearProveedor(Proveedor proveeedor) {
        proveedorRepository.insertarProveedor(proveeedor);
    }

    public void actualizarProveedor(Proveedor proveeedor) {
        proveedorRepository.actualizarProveedor(proveeedor);
    }

    @Transactional
    public List<Proveedor> obtenerProveedores() {
        return proveedorRepository.obtenerProveedores();
    }
}