package project.unimed.dev.fipe_api.service.exception;

public class ResourceNotFoundException  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
