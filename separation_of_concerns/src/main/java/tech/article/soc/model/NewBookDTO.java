package tech.article.soc.model;

public class NewBookDTO {

    private String author;
    private String title;
    private String publishingHouse;
    private int initialPublicationYear;
    private int currentPublicationYear;

    private String format;
    private int pageCount;

    private String state;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
