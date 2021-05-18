package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.BookFormat;
import tech.article.soc.model.BookState;
import tech.article.soc.model.DetailedBook;
import tech.article.soc.model.NewBookDTO;

/**
 * <pre>
 *     L'objectif est de montrer une application de separation of concern qui n'est pas pertinente.
 *
 *     Un cas fréquent est de faire des méthodes
 *
 *
 * </pre>
 */
public class BookReceptionServiceImpl implements BookReceptionService {

    private static final int WRITING_CREATION_YEAR = -7000;

    private BookRestorationService  bookRestorationService;
    private BookConverter bookConverter;
    private BookService bookService;

    @Override
    public void receiveNewBook(@NotNull NewBookDTO newBook) {
        if (newBook.getAuthor() == null || newBook.getAuthor().isBlank()) {
            throw new IllegalArgumentException("The author field is missing or is blank");
        }

        if (newBook.getTitle() == null || newBook.getTitle().isBlank()) {
            throw new IllegalArgumentException("The title field is missing or is blank");
        }

        if (newBook.getPublishingHouse() == null || newBook.getPublishingHouse().isBlank()) {
            throw new IllegalArgumentException("The publishingHouse field is missing or is blank");
        }

        if (newBook.getInitialPublicationYear() < WRITING_CREATION_YEAR) {
            throw new IllegalArgumentException("The initialPublicationYear field is invalid, the writing didnt exist at this time");
        }

        if (newBook.getCurrentPublicationYear() < newBook.getInitialPublicationYear()) {
            throw new IllegalArgumentException("The currentPublicationYear field shall not be lower than the initialPublicationYear");
        }


        if( newBook.getFormat()==null) {
            throw new IllegalArgumentException("The format of the book is missing");
        }
        try{
            BookFormat.valueOf(newBook.getFormat());
        } catch (Exception ex) {
            throw new IllegalArgumentException("The format of the book is unknown");
        }

        if( newBook.getPageCount() < 5 ) {
            throw new IllegalArgumentException("The number of pages is too low. The minimal page count is 5");
        }

        if( newBook.getState()== null) {
            throw new IllegalArgumentException("The state of the book is missing ");
        }

        try {
            BookState.valueOf(newBook.getState());
        } catch (Exception ex) {
            throw new IllegalArgumentException("The state of the book is unknown");
        }

        DetailedBook detailedBook = bookConverter.convertToDetailedBook(newBook);

        if (detailedBook.getState() == BookState.DAMAGED) {
            bookRestorationService.submit(detailedBook);
        } else {
            bookService.registerNewBook(detailedBook);
        }
    }
}
