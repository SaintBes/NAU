package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.Document;
import com.ukrinmash.ukraine.domain.DocumentSection;

import java.util.List;


public interface DocumentDAO {

    Long createDocument(Document document);
    void updateDocument(Document document);
    void deleteDocument(Document document);
    Document readDocument(Long docId);
    List<Document> findAllDocuments();
    List<Document> findBySection(DocumentSection section);


}
