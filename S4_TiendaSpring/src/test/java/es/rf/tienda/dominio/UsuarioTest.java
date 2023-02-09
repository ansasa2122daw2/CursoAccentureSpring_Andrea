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
	void testGetUser_nombre() throws DomainException {
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

}
