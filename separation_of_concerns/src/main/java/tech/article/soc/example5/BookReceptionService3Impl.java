package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
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
public class BookReceptionService3Impl implements BookReceptionService {


    private BookRestorationService bookRestorationService;
    private BookConverter bookConverter;
    private BookService bookService;

    @Override
    public void receiveNewBook(@NotNull NewBookDTO newBook) {
        BookDTOValidator.checkBookCorrectlyFilled(newBook);
        DetailedBook detailedBook = convertToDetailedBook(newBook);
        processNewBook(detailedBook);
    }


    @NotNull
    private DetailedBook convertToDetailedBook(@NotNull NewBookDTO newBook) {
        return bookConverter.convertToDetailedBook(newBook);
    }

    private void processNewBook(DetailedBook detailedBook) {
        if (detailedBook.getState() == BookState.DAMAGED) {
            bookRestorationService.submit(detailedBook);
        } else {
            bookService.registerNewBook(detailedBook);
        }
    }
}