package tech.article.soc.example4;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;
import tech.article.soc.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ModelLibraryService2Impl implements ModelLibraryService2 {

    private BookService bookService;
    private final Map<Client, Set<Book>> borrowedBookMap = new HashMap<>();

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @NotNull
    public Set<Book> getAvailableBooks() {
        Set<Book> borrowedBookSet = getBorrowedBooks();
        Set<Book> allBooks = bookService.getAllBooks();
        Set<Book> availableBookSet = new HashSet<>(allBooks);
        availableBookSet.removeAll(borrowedBookSet);
        return availableBookSet;
    }

    @NotNull
    private Set<Book> getBorrowedBooks() {
        return borrowedBookMap.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}