package tech.article.soc.model;

public class ClientAlreadyRegisteredException extends RuntimeException {
    public ClientAlreadyRegisteredException(String message) {
        super(message);
    }
}
