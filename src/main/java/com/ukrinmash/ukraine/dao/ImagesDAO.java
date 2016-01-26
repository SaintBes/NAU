package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.Document;
import com.ukrinmash.ukraine.domain.Images;

import java.util.List;

/**
 * Created by admssa on 23.11.2015.
 */
public interface ImagesDAO {

    Long createImages(Images image);
    void updateImages(Images image);
    void deleteImages(Images image);
    Images readImages(Long imageId);
    List<Images> findAiiByDocId(Document document);
    List<Images> findAllImages();

}
