package com.ukrinmash.ukraine.domain;

import java.util.List;

public class DocumentForJSTL {

    private Long docId;
    private String doc;
    private String docName;
    private List<String> images;
    private DocRating docRating;

    public DocumentForJSTL() {
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public DocRating getDocRating() {
        return docRating;
    }

    public void setDocRating(DocRating docRating) {
        this.docRating = docRating;
    }
}
