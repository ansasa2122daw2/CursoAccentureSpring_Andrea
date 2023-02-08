package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import es.rf.tienda.util.Validator;

class ValidatorTest {
	
	private String ALFANUMERIC = "23Epr ueba";
	private String ALFANUMERICERR = "1E{prueba";
	
	private String VACIO = "";
	private String VACIOERR = "hola";
	private String NULL = null;
	
	private String PHONE = "932661070981";
	private String PHONEERR = "9326";
	private String PHONEOK = "9326 61070 ";
	
	private String EMAIL = "andreasanchez@gmail.com";
	private String EMAILERR = "andreasanchez.gmail.com";
	private String EMAIL_ERR = "andrea@sanchezgmail";
	
	private String DNI = "26.062.256-N";
	private String DNIERR = "260.622.561.212-N";
	private String DNI_ERR = "26.062.256-O";
	private String DNI_ERR2 = "2620627256-N";
	
	private double VALORD = 5.0;
	private double VALORDERR = 2.0;
	private int VALOR = 5;
	private int MINIMO = 3;
	private int MAXIMO = 10;
	private int VALORERR = 2;
	private int MINIMOERR = 6;
	private int MAXIMOERR = 10;
	private int VALOR_ERR = -8;
	private int MINIMO_ERR = -6;
	private int MAXIMO_ERR = -10;
	
	private String TEXTO = "hola";
	private int LONGMIN = 3;
	private int LONGMAX = 9;
	private String TEXTOERR = "hol";
	private int LONGMINERR = 6;
	private String TEXTOMAXERR = "holaaaa";
	private int LONGMAXERR = 3;
	
	private LocalDate FECHA;
	private LocalDate FECHAMIN;
	private LocalDate FECHAMAX;
	
	private String FECHAV = "12/12/2002";
	private String FECHA_ERR = "12/12/22";
	private String FECHAERR = "12122002";
	private String FECHAERR2 = "12.12.2002";
	private String FECHA_ERR2 = "12.12/2002";
	
	private String CONTRA = "macedoniA1@";
	private String CONTRAOK = "-unodos@1ABC";
	private String CONTRAERR = "1212121212";
	private String CONTRA_ERR = "m2@A";
	
	private String PRODUCT = "IN325";
	private String PRODUCTERR = "989325";
	private String PRODUCTERR2 = "in9325";
	private String PRODUCTERR3 = "ineuoi";
	private String PRODUCTERR4 = "ION24";
	private String PRODUCTERR5 = "345OI";

	@Test
	void testIsAlfanumeric() {
		assertTrue(Validator.isAlfanumeric(ALFANUMERIC));
	}
	
	@Test
	void testIsAlfanumericERR() {
		assertFalse(Validator.isAlfanumeric(ALFANUMERICERR));
	}
	
	@Test
	void testIsVacio() {
		assertTrue(Validator.isVacio(VACIO));
	}
	
	@Test
	void testIsVacioERR() {
		assertFalse(Validator.isVacio(VACIOERR));
		assertFalse(Validator.isVacio(NULL));
	}


	@Test
	void testCumplePhoneNumberERR1() {
		assertFalse(Validator.cumplePhoneNumber(PHONEERR));
	}
	
	@Test
	void testCumplePhoneNumber2() {
		assertTrue(Validator.cumplePhoneNumber(PHONEOK));
	}
	
	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(PHONE));
	}

	@Test
	void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(EMAIL));
	}
	
	@Test
	void testIsEmailValidoERR() {
		assertFalse(Validator.isEmailValido(EMAILERR));
		assertFalse(Validator.isEmailValido(EMAIL_ERR));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI));
	}
	
	@Test
	void testCumpleDNIERR() {
		assertFalse(Validator.cumpleDNI(DNIERR));
	}
	
	@Test
	void testCumpleDNIERR2() {
		assertFalse(Validator.cumpleDNI(DNI_ERR));
		assertFalse(Validator.cumpleDNI(DNI_ERR2));
	}

	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(VALOR, MINIMO, MAXIMO));
	}
	
	@Test
	void testCumpleRangoIntIntIntERR() {
		assertFalse(Validator.cumpleRango(VALORERR, MINIMOERR, MAXIMOERR));
		assertFalse(Validator.cumpleRango(VALOR_ERR, MINIMO_ERR, MAXIMO_ERR));
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		assertTrue(Validator.cumpleRango(VALORD, MINIMO, MAXIMO));
	}
	
	@Test
	void testCumpleRangoDoubleIntIntERR() {
		assertFalse(Validator.cumpleRango(VALORDERR, MINIMO, MAXIMO));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO, LONGMIN));
	}
	
	@Test
	void testCumpleLongitudMinERR() {
		assertFalse(Validator.cumpleLongitudMin(TEXTOERR, LONGMINERR));
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO, LONGMAX));
	}
	
	@Test
	void testCumpleLongitudMaxERR() {
		assertFalse(Validator.cumpleLongitudMax(TEXTOMAXERR, LONGMAXERR));
	}

	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud(TEXTO, LONGMIN, LONGMAX));
	}
	
	@Test
	void testCumpleLongitudERR() {
		assertFalse(Validator.cumpleLongitud(TEXTOERR, LONGMINERR, LONGMAXERR));
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA.of(2002, 12, 12), FECHAMIN.of(2000, 12, 12)));
	}
	
	@Test
	void testValDateMinERR() {
		assertFalse(Validator.valDateMin(FECHA.of(1999, 12, 12), FECHAMIN.of(2000, 12, 10)));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA.of(2002, 12, 10), FECHAMAX.of(2004, 12, 12)));
	}
	
	@Test
	void testValDateMaxERR() {
		assertFalse(Validator.valDateMax(FECHA.of(2002, 12, 10), FECHAMAX.of(2002, 10, 12)));
	}

	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHAV));
	}
	
	@Test
	void testEsFechaValidaERR() {
		assertFalse(Validator.esFechaValida(FECHAERR));
		assertFalse(Validator.esFechaValida(FECHA_ERR));
		assertFalse(Validator.esFechaValida(FECHAERR2));
		assertFalse(Validator.esFechaValida(FECHA_ERR2));
	}

	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(CONTRA));
		assertTrue(Validator.esPasswordValida(CONTRAOK));
	}
	
	@Test
	void testEsPasswordValidaERR() {
		assertFalse(Validator.esPasswordValida(CONTRAERR));
		assertFalse(Validator.esPasswordValida(CONTRA_ERR));
	}
	
	@Test
	void testFiltroProducto() {
		assertTrue(Validator.filtroProducto(PRODUCT));
		assertFalse(Validator.filtroProducto(PRODUCTERR));
		assertFalse(Validator.filtroProducto(PRODUCTERR2));
		assertFalse(Validator.filtroProducto(PRODUCTERR3));
		assertFalse(Validator.filtroProducto(PRODUCTERR4));
		assertFalse(Validator.filtroProducto(PRODUCTERR5));
	}

}
