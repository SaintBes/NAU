package com.ukrinmash.ukraine.service;

import com.ukrinmash.ukraine.domain.DocRating;
import com.ukrinmash.ukraine.domain.Document;
import com.ukrinmash.ukraine.domain.DocumentSection;
import com.ukrinmash.ukraine.domain.Images;

import java.util.List;

/**
 * Created by admssa on 23.11.2015.
 */
public interface DocumentsService {

    public void addNewArticle(Document document, List<Images> images);
    public List<Document> getAllDocs();
    public List<Images> getAllImages();
    public List<Images> getImages(Document document);
    public List<Document> getBySection(DocumentSection section);
    public Document getDocById(Long docId);
    public DocRating getRatingById(Long docRatingId);
    public void updateRating(DocRating docRating);
    public Long addRating(DocRating docRating);
    public Long saveRating(DocRating docRating);
    public void deleteDocument(Document document);
    public void deleteRating(DocRating docRating);
    public void deleteImage(Images images);
}
