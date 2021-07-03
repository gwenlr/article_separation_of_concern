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
public class BookReceptionService2Impl implements BookReceptionService {

    private static final int WRITING_CREATION_YEAR = -7000;

    private BookRestorationService bookRestorationService;
    private BookConverter bookConverter;
    private BookService bookService;

    @Override
    public void receiveNewBook(@NotNull NewBookDTO newBook) {
        checkBookCorrectlyFilled(newBook);
        DetailedBook detailedBook = convertToDetailedBook(newBook);
        processNewBook(detailedBook);
    }


    private void checkBookCorrectlyFilled(@NotNull NewBookDTO newBook) {
        checkAuthor(newBook);
        checkTitle(newBook);
        checkPublicationHouse(newBook);
        checkPublication(newBook);
        checkFormat(newBook);
        checkPageCount(newBook);
        checkState(newBook);
    }

    private void checkAuthor(@NotNull NewBookDTO newBook) {
        if (newBook.getAuthor() == null || newBook.getAuthor().isBlank()) {
            throw new IllegalArgumentException("The author field is missing or is blank");
        }
    }

    private void checkTitle(@NotNull NewBookDTO newBook) {
        if (newBook.getTitle() == null || newBook.getTitle().isBlank()) {
            throw new IllegalArgumentException("The title field is missing or is blank");
        }
    }

    private void checkPublicationHouse(@NotNull NewBookDTO newBook) {
        if (newBook.getPublishingHouse() == null || newBook.getPublishingHouse().isBlank()) {
            throw new IllegalArgumentException("The publishingHouse field is missing or is blank");
        }
    }

    private void checkPublication(@NotNull NewBookDTO newBook) {
        checkInitialPublicationIsNotTooOld(newBook);
        checkCurrentPublicationCoherentWithInitialPublication(newBook);
    }

    private void checkInitialPublicationIsNotTooOld(@NotNull NewBookDTO newBook) {
        if (newBook.getInitialPublicationYear() < WRITING_CREATION_YEAR) {
            throw new IllegalArgumentException("The initialPublicationYear field is invalid, the writing didnt exist at this time");
        }
    }

    private void checkCurrentPublicationCoherentWithInitialPublication(@NotNull NewBookDTO newBook) {
        if (newBook.getCurrentPublicationYear() < newBook.getInitialPublicationYear()) {
            throw new IllegalArgumentException("The currentPublicationYear field shall not be lower than the initialPublicationYear");
        }
    }

    private void checkFormat(@NotNull NewBookDTO newBook) {
        checkFormatFilled(newBook);
        checkFormatHasValidValue(newBook);
    }

    private void checkFormatFilled(@NotNull NewBookDTO newBook) {
        if (newBook.getFormat() == null) {
            throw new IllegalArgumentException("The format of the book is missing");
        }
    }

    private void checkFormatHasValidValue(@NotNull NewBookDTO newBook) {
        try {
            BookFormat.valueOf(newBook.getFormat());
        } catch (Exception ex) {
            throw new IllegalArgumentException("The format is unknown");
        }
    }

    private void checkPageCount(@NotNull NewBookDTO newBook) {
        if (newBook.getPageCount() < 5) {
            throw new IllegalArgumentException("The number of pages is too low. The minimal page count is 5");
        }
    }

    private void checkState(@NotNull NewBookDTO newBook) {
        checkStateFilled(newBook);
        checkStateHasValidValue(newBook);
    }

    private void checkStateFilled(@NotNull NewBookDTO newBook) {
        if (newBook.getState() == null) {
            throw new IllegalArgumentException("The state of the book is missing");
        }
    }

    private void checkStateHasValidValue(@NotNull NewBookDTO newBook) {
        try {
            BookState.valueOf(newBook.getState());
        } catch (Exception ex) {
            throw new IllegalArgumentException("The state of the book is unknown");
        }
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