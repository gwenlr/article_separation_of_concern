package tech.article.soc.model;

public class UnknownBookException extends RuntimeException{
    public UnknownBookException(String message) {
        super(message);
    }
}
