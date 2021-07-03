package tech.article.soc.example5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Assertions {

    private Assertions() {
        throw new UnsupportedOperationException("Utility class cannot be instanced");
    }


    public static void assertNotBlank(@Nullable String string, @NotNull String message) {
        assertTrue(string != null && !string.isBlank(), message);
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertNotNull(@Nullable Object object, @NotNull String message) {
        assertTrue(object != null, message);
    }

}
