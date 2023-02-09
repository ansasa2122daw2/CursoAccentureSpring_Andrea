package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Direccion;

public interface IServicioDireccion {

	public boolean insert(Direccion t);
	public boolean update(Direccion t);
	public boolean deleteById(String s);
	public List<Direccion> listAll();
	public Direccion leerUno(String s);
}
