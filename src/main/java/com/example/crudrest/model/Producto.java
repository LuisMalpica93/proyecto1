package com.example.crudrest.model;

public class Producto {
	private Integer id;
    private String nombre;
    private String detalle;
    private String codigo;
    private Double precio;
    private Integer proveedor_id;
    
    public Producto() {
    	
    }

	public Producto(Integer id, String nombre, String detalle, String codigo, Double precio, Integer proveedor_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.codigo = codigo;
		this.precio = precio;
		this.proveedor_id = proveedor_id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}





	public Integer getProveedor_id() {
		return proveedor_id;
	}





	public void setProveedor_id(Integer proveedor_id) {
		this.proveedor_id = proveedor_id;
	}
	
    
    
}
