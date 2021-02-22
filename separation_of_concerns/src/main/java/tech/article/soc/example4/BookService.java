package tech.article.soc.example4;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.Book;

import java.util.Set;

public interface BookService {

    @NotNull
    Set<Book> getAllBooks();

}
