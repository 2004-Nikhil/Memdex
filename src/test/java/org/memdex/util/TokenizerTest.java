package org.memdex.util;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TokenizerTest {
    @Test
    void testBasicTokenization() {
        Tokenizer tokenizer = new Tokenizer();
        String text = "Hello World! This is a Search-Engine.";
        List<String> expected = List.of("hello", "world", "this", "is", "a", "search", "engine");
        List<String> actual = tokenizer.tokenize(text);
        assertEquals(expected, actual);
    }
}
