package org.memdex;

import org.memdex.core.Indexer;
import java.util.List;
import java.io.IOException;

public class SearchApp {
    public static void main(String []args) {
        System.out.println("Starting In-Memory Search Engine...");
        Indexer indexer = new Indexer();

        try {
            // 1 Indexing Phase
            System.out.println("Indexing document..");
            indexer.indexFile("test-data/file1.txt");
            indexer.indexFile("test-data/file2.txt");
            System.out.println("Indexing complete.");

            // Searching phase
            String searchTerm = "brown";
            System.out.println("\nSearching for term: '"+ searchTerm+"'");

            List<String> result = indexer.search(searchTerm);

            if(result.isEmpty()) {
                System.out.println("Term not found");
            } else {
                System.out.println("Found in the following ");
                result.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
