package tech.article.soc.model;

public class UnknownClientException extends RuntimeException{
    public UnknownClientException(String message) {
        super(message);
    }
}
