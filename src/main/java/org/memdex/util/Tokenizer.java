package org.memdex.util;
import java.util.*;
import java.util.stream.Collectors;

public class Tokenizer {
    public List<String> tokenize(String text){

        if(text == null || text.isEmpty()) {
            return List.of();
        }
        // convert to lower, replace all non-alphanumeric character with space, split by whitespace

        String [] words =    text.toLowerCase()
                                .replaceAll("[^a-zA-Z0-9\\s]", " ")
                                .split("\\s+");
        // filter out any empty string
        return Arrays.stream(words)
                     .filter(word -> !word.isBlank())
                     .collect(Collectors.toList());
    }
}
