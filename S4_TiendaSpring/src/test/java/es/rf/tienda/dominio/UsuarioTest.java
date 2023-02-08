package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class UsuarioTest {
	private String userN = "Andrea";
	private String userNERR = "AndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndreaAndrea";
	private String userNERR2 = "Al";
	private String userNERR3 = "12345";
	
	Usuario usu;

	@BeforeEach
	void creacion() {
		usu = new Usuario();
	}

	@Test
	void testGetUser_nombre() {
		usu.setUser_nombre(userN);
		assertEquals(userN, usu.getUser_nombre());
	}
	
	@Test
	void testGetUser_nombreERR()throws DomainException {
		usu.setUser_nombre(userNERR);
		Assertions.assertThrows(DomainException.class, () -> {
			usu.getUser_nombre();
		});
	}

	@Test
	void testGetUser_email() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUser_pass() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId_tipo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUser_dni() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUser_fecAlta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUser_fecConfirmacion() {
		fail("Not yet implemented");
	}



}
