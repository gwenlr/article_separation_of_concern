package tech.article.soc.example4;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech.article.soc.model.Book;
import tech.article.soc.model.BookJson;
import tech.article.soc.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryRestService {

    private BookService bookService;
    private final Map<Client, Set<Book>> borrowedBookMap = new HashMap<>();

    /**
     * Get the available books
     *
     * @return a list of books ordered by title
     */
    @GetMapping("/books/available")
    @NotNull
    public ResponseEntity<List<BookJson>> getAvailableBooks() {
        Set<Book> availableBookSet = getAvailableBookSet();
        if( availableBookSet.isEmpty())
            return ResponseEntity.noContent().build();

        List<BookJson> orderedJsonBookList = toJson(availableBookSet);
        return ResponseEntity.ok(orderedJsonBookList);
    }


    @NotNull
    private Set<Book> getAvailableBookSet() {
        Set<Book> borrowedBookSet = borrowedBookMap.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        Set<Book> availableBookSet = new HashSet<>(bookService.getAllBooks());
        availableBookSet.removeAll(borrowedBookSet);
        return availableBookSet;
    }


    @NotNull
    private static List<BookJson> toJson(@NotNull Collection<Book> availableBookSet) {
        return availableBookSet.stream()
                .map(LibraryRestService::toJson)
                .sorted(Comparator.comparing(BookJson::getTitle))
                .collect(Collectors.toList());
    }


    @NotNull
    private static BookJson toJson(@NotNull Book book) {
        BookJson jsonBook = new BookJson();
        jsonBook.setAuthor(book.getAuthor());
        jsonBook.setPublisher(book.getPublisher());
        jsonBook.setTitle(book.getTitle());
        return jsonBook;
    }
}