package com.ukrinmash.ukraine.service;

import com.ukrinmash.ukraine.dao.DocRatingDAO;
import com.ukrinmash.ukraine.dao.DocumentDAO;
import com.ukrinmash.ukraine.dao.ImagesDAO;
import com.ukrinmash.ukraine.domain.DocRating;
import com.ukrinmash.ukraine.domain.Document;
import com.ukrinmash.ukraine.domain.DocumentSection;
import com.ukrinmash.ukraine.domain.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentsServiceImpl implements DocumentsService {

    @Autowired
    DocumentDAO documentDAO;

    @Autowired
    ImagesDAO imagesDAO;

    @Autowired
    DocRatingDAO docRatingDAO;

    public DocumentsServiceImpl() {
    }

    @Override
    public void addNewArticle(Document document, List<Images> images) {

        Long docId = documentDAO.createDocument(document);
        for (Images image : images) {
            image.setDocument(documentDAO.readDocument(docId));
            imagesDAO.createImages(image);
        }


    }

    @Override
    @Transactional(readOnly = true)
    public List<Document> getAllDocs() {
        return (List<Document>) documentDAO.findAllDocuments();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Images> getAllImages() {
        return (List<Images>) imagesDAO.findAllImages();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Images> getImages(Document document) {
        return  (List<Images>) imagesDAO.findAiiByDocId(document);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Document> getBySection(DocumentSection section) {
        return (List<Document>) documentDAO.findBySection(section);
    }

    @Override
    public Document getDocById(Long docId) {
        return documentDAO.readDocument(docId);
    }

    @Override
    public DocRating getRatingById(Long docRatingId) {
        return docRatingDAO.readRaring(docRatingId);
    }

    @Override
    public void updateRating(DocRating docRating) {
        docRatingDAO.updateRating(docRating);
    }

    @Override
    public Long addRating(DocRating docRating) {
        return docRatingDAO.createRating(docRating);
    }

    @Override
    public Long saveRating(DocRating docRating) {
        return docRatingDAO.createRating(docRating);
    }

    @Override
    public void deleteDocument(Document document) {
        documentDAO.deleteDocument(document);
    }

    @Override
    public void deleteRating(DocRating docRating) {
        docRatingDAO.deleteRating(docRating);
    }

    @Override
    public void deleteImage(Images images) {
        imagesDAO.deleteImages(images);
    }


}





