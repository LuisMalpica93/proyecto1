package com.example.crudrest.model;

public class Proveedor {
	private Integer id;
    private String nombre;
    private String detalle;
    private String rfc;
    private String telefono;
    
    public Proveedor() {
    	
    }
    
	public Proveedor(Integer id, String nombre, String detalle, String rfc, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.rfc = rfc;
		this.telefono = telefono;
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
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
    
}
