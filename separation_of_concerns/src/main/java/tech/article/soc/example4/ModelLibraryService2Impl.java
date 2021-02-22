package tech.article.soc.example4;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;
import tech.article.soc.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ModelLibraryService2Impl implements ModelLibraryService2 {

    private final Set<Book> bookSet = new HashSet<>();
    private final Set<Client> clientSet = new HashSet<>();
    private final Map<Client, Set<Book>> borrowedBookMap = new HashMap<>();

    @Override
    @NotNull
    public Set<Book> getAvailableBooks() {
        Set<Book> borrowedBookSet = getBorrowedBooks();
        Set<Book> availableBookSet = new HashSet<>(bookSet);
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