package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

/**
 * Interface Servicio Categoria
 * @author andrea.sanclemente
 *
 */

public interface IServicioCategoria{

	public void insert(Categoria t) throws DomainException, DAOException;
	public boolean update(Categoria t) throws DomainException;
	public boolean deleteById(int s);
	public List<Categoria> listAll();
	public Categoria leerUno(int s);
	
}
