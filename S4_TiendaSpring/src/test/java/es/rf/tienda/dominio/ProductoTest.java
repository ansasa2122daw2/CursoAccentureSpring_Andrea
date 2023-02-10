package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class ProductoTest {
	private String IDPRODUCTO = "12";
	private String IDPRODUCTOERR = "121222";
	
	private String PRODESCRIPCION = "Descripcion";
	private String PRODESCRIPCIONERR = "xD";
	private String PRODESCRIPCIONERR2 = "DescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcionDescripcion";

	private double PROPRECIO = 90.50;
	private double PROPRECIOERR = 120.00;
	
	Producto prod;

	@BeforeEach
	void creacion() {
		prod = new Producto();
	}
	@Test
	void testGetId_producto() throws DomainException {
		prod.setId_producto(IDPRODUCTO);
		assertEquals(IDPRODUCTO, prod.getId_producto());
	}
	
	@Test
	void testGetId_productoERR() throws DomainException {
		prod.setId_producto(IDPRODUCTOERR);
		Assertions.assertThrows(DomainException.class, () -> {
			prod.getId_producto();
		});
	}

	@Test
	void testGetPro_descripcion() throws DomainException {
		prod.setPro_descripcion(PRODESCRIPCION);
		assertEquals(PRODESCRIPCION, prod.getPro_descripcion());
	}
	
	@Test
	void testGetPro_descripcionERR() throws DomainException {
		prod.setPro_descripcion(PRODESCRIPCIONERR);
		Assertions.assertThrows(DomainException.class, () -> {
			prod.getPro_descripcion();
		});
	}
	
	@Test
	void testGetPro_descripcionERR2() throws DomainException {
		prod.setPro_descripcion(PRODESCRIPCIONERR2);
		Assertions.assertThrows(DomainException.class, () -> {
			prod.getPro_descripcion();
		});
	}

	@Test
	void testGetPro_desLarga() throws DomainException {
		prod.setPro_desLarga(PRODESCRIPCION);
		assertEquals(PRODESCRIPCION, prod.getPro_desLarga());
	}
	
	@Test
	void testGetPro_desLargaERR() throws DomainException {
		prod.setPro_desLarga(PRODESCRIPCIONERR);
		Assertions.assertThrows(DomainException.class, () -> {
			prod.getPro_desLarga();
		});
	}

	@Test
	void testGetPro_precio() throws DomainException {
		prod.setPro_precio(PROPRECIO);
		assertEquals(PROPRECIO, prod.getPro_precio());
	}

	@Test
	void testGetPro_fecRepos() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecActi() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_FecDesacti() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_uniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_stat() {
		fail("Not yet implemented");
	}

}
