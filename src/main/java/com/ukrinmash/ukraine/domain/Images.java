package com.ukrinmash.ukraine.domain;

import javax.persistence.*;

@Entity
@Table(name = "IMAGES")
public class Images {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
    private long imageId;

    @Lob
    private  byte[] binaryImage;

    private String fileName;
    private Long fileSize;
    private String fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docId")
    Document document;

    public Images() {
    }

    public long getId() {
        return imageId;
    }

    public void setId(long id) {
        this.imageId = id;
    }


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public byte[] getBinaryImage() {
        return binaryImage;
    }

    public void setBinaryImage(byte[] binaryImage) {
        this.binaryImage = binaryImage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
