public class DuplicateKeyException extends Exception {
    public DuplicateKeyException() {
        super("Unable to add key/value pair. Key already exists.");
    }
}
