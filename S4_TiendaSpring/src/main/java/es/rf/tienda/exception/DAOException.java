package es.rf.tienda.exception;

public class DAOException extends Exception {
	
	public DAOException() {
		super("Error DAO Exception");
	}
	
	public DAOException(String arg0) {
		super("DAO Exception:" + arg0);
	}
	
}
