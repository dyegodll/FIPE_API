package project.unimed.dev.fipe_api.service.exception;

public class DataBaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataBaseException(String msg) {
		super(msg);
	}
}
