package tech.article.soc.example4;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;

import java.util.Set;

public interface ModelLibraryService2 {

    @NotNull
    Set<Book> getAvailableBooks();
}
