package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import tech.article.soc.model.DetailedBook;

public interface  BookRestorationService {
    void submit(@NotNull DetailedBook book);
}
