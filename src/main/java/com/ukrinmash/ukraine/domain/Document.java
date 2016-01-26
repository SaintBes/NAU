package com.ukrinmash.ukraine.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "DOCUMENTS")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long docId;

    private String documentName;

    @Size(max = 2000)
    private String html;

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
    List<Images> imagesList;

    @Enumerated(EnumType.STRING)
    private DocumentSection section;

    @OneToOne(fetch = FetchType.EAGER)
    DocRating docRating;


    public Document() {
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<Images> getImages() {
        return imagesList;
    }

    public void setImages(List<Images> images) {
        this.imagesList = images;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public DocumentSection getSection() {
        return section;
    }

    public void setSection(DocumentSection section) {
        this.section = section;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public DocRating getDocRating() {
        return docRating;
    }

    public void setDocRating(DocRating docRating) {
        this.docRating = docRating;
    }
}
