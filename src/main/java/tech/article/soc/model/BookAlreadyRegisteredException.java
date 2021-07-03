package tech.article.soc.model;

public class BookAlreadyRegisteredException extends RuntimeException {
    public BookAlreadyRegisteredException(String message) {
        super(message);
    }
}
