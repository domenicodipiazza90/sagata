package it.dipiazza.domenico.infrastructure;

@SuppressWarnings("serial")
public class ActionException extends Exception {
	public ActionException(String message, Throwable cause) {
		super(message, cause);
	}
}
