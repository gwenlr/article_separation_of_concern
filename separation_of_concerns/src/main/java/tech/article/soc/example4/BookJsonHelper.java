package tech.article.soc.example4;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;
import tech.article.soc.model.BookJson;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class BookJsonHelper {

    private BookJsonHelper() {
        throw new UnsupportedOperationException("Helper class cannot be instanced");
    }

    @NotNull
    public static List<BookJson> toJson(@NotNull Collection<Book> availableBookSet) {
        return availableBookSet.stream()
                .map(BookJsonHelper::toJson)
                .sorted(Comparator.comparing(BookJson::getTitle))
                .collect(Collectors.toList());
    }

    @NotNull
    public static BookJson toJson(@NotNull Book book) {
        BookJson jsonBook = new BookJson();
        jsonBook.setAuthor(book.getAuthor());
        jsonBook.setPublisher(book.getPublisher());
        jsonBook.setTitle(book.getTitle());
        return jsonBook;
    }
}