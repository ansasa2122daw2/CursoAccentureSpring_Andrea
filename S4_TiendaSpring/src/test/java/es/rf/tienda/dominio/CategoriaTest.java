package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;

class CategoriaTest {
	private static final String descr = "Contador de caracteres tengo que llegar a doscientos para que salga error y poder verificar que el Test y la clase dominio está bien. Este es el texto de test por el cual estoy intentando alargar.";
	private static final String descrERR = "Contador de caracteres tengo que llegar a doscientos para que salga error y poder verificar que el Test y la clase dominio está bien si no, no podré comprobarlo. Este es el texto de test por el cual estoy intentando alargar.";
	
	private static final String nombreOK = "Andrea";
	private static final String nombreFAIL = "Al";
	
	Categoria cat;

	@BeforeEach
	void creacion() {
		cat = new Categoria();
	}

	@Test
	void testGetCat_nombre() throws DomainException {
		cat.setCat_nombre(nombreOK);
		assertEquals(nombreOK, cat.getCat_nombre());
	}
	
	@Test
	void testGetCat_nombreERR() throws DomainException {
		cat.setCat_nombre(nombreFAIL);
		Assertions.assertThrows(DomainException.class, () -> {
			cat.getCat_nombre();
		});
	}

	@Test
	void testGetCat_descripcion() throws DomainException {
		cat.setCat_descripcion(descr);
		assertEquals(descr, cat.getCat_descripcion());
	}
	
	@Test
	void testGetCat_descripcionERR() throws DomainException {
		cat.setCat_descripcion(descrERR);
		Assertions.assertThrows(DomainException.class, () -> {
			cat.getCat_descripcion();
		});
	}
	
	

}
