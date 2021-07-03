package tech.article.soc.model;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.BookFormat;
import tech.article.soc.model.BookState;

public class DetailedBook {

    private String author;
    private String title;
    private String publishingHouse;
    private int initialPublicationYear;
    private int currentPublicationYear;

    private BookFormat format;
    private int pageCount;

    private BookState state;


    @NotNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull String author) {
        this.author = author;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(@NotNull String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getInitialPublicationYear() {
        return initialPublicationYear;
    }

    public void setInitialPublicationYear(int initialPublicationYear) {
        this.initialPublicationYear = initialPublicationYear;
    }

    public int getCurrentPublicationYear() {
        return currentPublicationYear;
    }

    public void setCurrentPublicationYear(int currentPublicationYear) {
        this.currentPublicationYear = currentPublicationYear;
    }

    @NotNull
    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(@NotNull BookFormat format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @NotNull
    public BookState getState() {
        return state;
    }

    public void setState(@NotNull BookState state) {
        this.state = state;
    }

}