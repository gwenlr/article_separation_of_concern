package tech.article.soc.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notEmpty;

public class Book {

    private final String title;
    private final String author;
    private final String publisher;


    public Book(String title, String author, String publisher) {
        this.title = notEmpty(title, "title argument shall not be null nor empty");
        this.author = notEmpty(author, "author argument shall not be null nor empty");
        this.publisher = notEmpty(publisher, "publisher argument shall not be null nor empty");
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                publisher.equals(book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }
}