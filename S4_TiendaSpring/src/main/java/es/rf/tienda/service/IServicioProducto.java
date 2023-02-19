package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

public interface IServicioProducto {

	public void insert(Producto t) throws DomainException, DAOException;
	public void update(Producto t) throws DomainException, DAOException;
	public boolean deleteById(String s);
	public List<Producto> listAll();
	public Producto leerUno(String s);
	
}
