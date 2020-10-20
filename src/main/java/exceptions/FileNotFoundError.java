package exceptions;

public class FileNotFoundError extends Exception {
    public FileNotFoundError(String message) {
        super(message);
    }
}
