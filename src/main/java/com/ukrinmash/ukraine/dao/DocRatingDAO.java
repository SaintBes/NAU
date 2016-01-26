package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.DocRating;

import java.util.List;

/**
 * Created by admssa on 13.12.2015.
 */
public interface DocRatingDAO {

    Long createRating(DocRating docRating);
    void updateRating(DocRating docRating);
    void deleteRating(DocRating rating);
    DocRating readRaring(Long ratingId);
    List<DocRating> findAllRatings();

}
