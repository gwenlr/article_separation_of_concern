package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.BookFormat;
import tech.article.soc.model.BookState;
import tech.article.soc.model.NewBookDTO;

import static tech.article.soc.example5.Assertions.*;

public class BookDTOValidator {

    private static final int WRITING_CREATION_YEAR = -7000;

    private BookDTOValidator() {
        throw new UnsupportedOperationException("An utility class cannot be instanced");
    }


    public static void checkBookCorrectlyFilled(@NotNull NewBookDTO newBook) {
        checkAuthor(newBook);
        checkTitle(newBook);
        checkPublicationHouse(newBook);
        checkPublication(newBook);
        checkFormat(newBook);
        checkPageCount(newBook);
        checkState(newBook);
    }

    private static void checkAuthor(@NotNull NewBookDTO newBook) {
        assertNotBlank(newBook.getAuthor(), "The author field is missing or is blank");
    }


    private static void checkTitle(@NotNull NewBookDTO newBook) {
        assertNotBlank(newBook.getTitle(), "The title field is missing or is blank");
    }

    private static void checkPublicationHouse(@NotNull NewBookDTO newBook) {
        assertNotBlank(newBook.getPublishingHouse(), "The publishingHouse field is missing or is blank");
    }

    private static void checkPublication(@NotNull NewBookDTO newBook) {
        assertTrue(newBook.getInitialPublicationYear() < WRITING_CREATION_YEAR,
                "The initialPublicationYear field is invalid, the writing didnt exist at this time");
        assertTrue(newBook.getCurrentPublicationYear() < newBook.getInitialPublicationYear(),
                "The currentPublicationYear field shall not be lower than the initialPublicationYear");
    }


    private static void checkFormat(@NotNull NewBookDTO newBook) {
        assertNotNull(newBook.getFormat(), "The format of the book is missing");
        try {
            BookFormat.valueOf(newBook.getFormat());
        } catch (Exception ex) {
            throw new IllegalArgumentException("The format is unknown");
        }
    }


    private static void checkPageCount(@NotNull NewBookDTO newBook) {
        assertTrue(newBook.getPageCount() >= 5, "The number of pages is too low. The minimal page count is 5");
    }

    private static void checkState(@NotNull NewBookDTO newBook) {
        assertNotNull(newBook.getState(), "The state of the book is missing");
        try {
            BookState.valueOf(newBook.getState());
        } catch (Exception ex) {
            throw new IllegalArgumentException("The state of the book is unknown");
        }
    }
}