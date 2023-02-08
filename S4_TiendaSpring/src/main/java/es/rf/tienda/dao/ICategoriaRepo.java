package es.rf.tienda.dao;

import es.rf.tienda.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer>{

}
