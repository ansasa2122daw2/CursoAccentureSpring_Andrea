package es.rf.tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Producto;

public interface IProductoRepo extends JpaRepository<Producto, String>{

}
