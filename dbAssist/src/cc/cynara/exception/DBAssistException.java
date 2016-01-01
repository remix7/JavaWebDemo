package cc.cynara.exception;

public class DBAssistException extends RuntimeException {

	public DBAssistException() {
	}

	public DBAssistException(String message) {
		super(message);
	}

	public DBAssistException(Throwable cause) {
		super(cause);
	}

	public DBAssistException(String message, Throwable cause) {
		super(message, cause);
	}

}
