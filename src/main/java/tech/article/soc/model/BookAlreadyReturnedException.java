package tech.article.soc.model;

public class BookAlreadyReturnedException extends Exception {
    public BookAlreadyReturnedException(String message) {
        super(message);
    }
}
