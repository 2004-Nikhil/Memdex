package org.memdex.model;

public class DocumentInfo {
    private final int docId;
    private final String path;
    private int totalWords;

    public DocumentInfo(int docId,String path) {
        this.docId = docId;
        this.path = path;
    }

    // getters
    public int getDocId() { return docId; }
    public String getPath() { return path; }

}
