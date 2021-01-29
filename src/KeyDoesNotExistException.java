public class KeyDoesNotExistException extends Exception {
    public KeyDoesNotExistException() {
        super("Unable to complete your request. Key/Value pair does not exist.");
    }
}
