package org.memdex.core;

import org.memdex.util.Tokenizer;
import org.memdex.model.DocumentInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Indexer {
    // map a token to a list of document IDs
    private final Map<String,List<Integer>> invertedIndex = new HashMap<>();

    // store metadata about each document
    private final Map<Integer,DocumentInfo> documentStore = new HashMap<>();

    private final Tokenizer tokenizer = new Tokenizer();
    private int nextDocId = 0;

    // Indexes a single document
    public void indexFile(String filePath) throws IOException {
        int docId = nextDocId++;
        String content = Files.readString(Paths.get(filePath));
        List<String> tokens = tokenizer.tokenize(content);

        // store document metadata
        documentStore.put(docId,new DocumentInfo(docId,filePath));

        // update the inverted index
        for(String token: tokens) {
            // get the list of docs for this token, or create a new list if it's the first time
            List<Integer> docIds = invertedIndex.computeIfAbsent(token,k -> new ArrayList<>());

            // Add the current docId only if it's not already there for this token
            if(!docIds.contains(docId)) {
                docIds.add(docId);
            }
        }
    }

    // perform a simple search for a term
    public List<String> search(String term) {
        String provessedTerm = term.toLowerCase();
        List<Integer> docIds = invertedIndex.getOrDefault(provessedTerm,List.of());
        List<String> results = new ArrayList<>();
        for(int docId : docIds) {
            results.add(documentStore.get(docId).getPath());
        }
        return results;
    }
}
