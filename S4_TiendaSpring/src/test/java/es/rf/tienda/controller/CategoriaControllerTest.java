package es.rf.tienda.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.service.ServicioCategoria;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Mensaje;

/**
 * Clase Controlador usando mockito
 * @author andrea.sanclemente
 *
 */
class CategoriaControllerTest {
	
	@InjectMocks
	ServicioCategoria sCat;

	@Mock
	CategoriaController cCat;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	private static final int IDC = 1;
	private static final int IDC2 = 2;
	private static final int IDC3 = 3;
	private static final String CNOMBRE = "Prueba con JUnit";
	private static final String CDESC = "Prueba con JUnit Descripcion";
	
	private static final String MENERR= "Categoria delete";
	private static final int COERR= 200;
	
	private static final String BORRADO = "SUCCES";

	@Test
	void testLeerUno() throws DomainException {
		Categoria cat = new Categoria();
		cat.setId_categoria(IDC);
		cat.setCat_nombre(CNOMBRE);
		cat.setCat_descripcion(CDESC);
		
		assertEquals(IDC, cat.getId_categoria());
		assertEquals(CNOMBRE, cat.getCat_nombre());
		assertEquals(CDESC, cat.getCat_descripcion());
	}
	
	@Test
	void testLeerTodos() {
		List<Categoria> list = new ArrayList<Categoria>();
		Categoria cat1 = new Categoria(IDC, CNOMBRE, CDESC);
		Categoria cat2 = new Categoria(IDC2, CNOMBRE, CDESC);
		Categoria cat3 = new Categoria(IDC3, CNOMBRE, CDESC);

		list.add(cat1);
		list.add(cat2);
		list.add(cat3);

		when(cCat.leerTodos()).thenReturn(list);

		//test
		List<Categoria> empList = cCat.leerTodos();

		assertEquals(3, empList.size());
		verify(cCat, times(1)).leerTodos();
	}

	@Test
	void testDelete() {
		Categoria cat1 = new Categoria(IDC,CNOMBRE,CDESC);
		Mensaje err = new Mensaje(COERR, MENERR);

		int IDCAT = cat1.getId_categoria();
		String conver = Integer.toString(IDCAT);
		
		when(cCat.delete(conver)).thenReturn(err);
		Mensaje men = cCat.delete(conver);
		assertEquals(men,cat1);
	}

	@Test
	void testAlta() {
		fail("Not yet implemented");
	}

	@Test
	void testModificacion() {
		fail("Not yet implemented");
	}

}
