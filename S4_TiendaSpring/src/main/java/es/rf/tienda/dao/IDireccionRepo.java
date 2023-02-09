package es.rf.tienda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Direccion;

public interface IDireccionRepo extends JpaRepository<Direccion, String>{

}
