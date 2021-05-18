package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.DetailedBook;

public interface BookService {
    void registerNewBook(@NotNull DetailedBook book);
}
