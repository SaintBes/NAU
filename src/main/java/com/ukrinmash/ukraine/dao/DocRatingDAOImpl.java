package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.DocRating;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admssa on 13.12.2015.
 */
@Repository
public class DocRatingDAOImpl implements DocRatingDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long createRating(DocRating docRating) {
        sessionFactory.getCurrentSession().save(docRating);
        return docRating.getRatingId();
    }

    @Override
    public void updateRating(DocRating docRating) {
        sessionFactory.getCurrentSession().update(docRating);
    }

    @Override
    public void deleteRating(DocRating rating) {
        sessionFactory.getCurrentSession().delete(rating);
    }

    @Override
    public DocRating readRaring(Long ratingId) {
        return (DocRating) sessionFactory.getCurrentSession().get(DocRating.class,ratingId);
    }

    @Override
    public List<DocRating> findAllRatings() {
        return (List<DocRating>) sessionFactory.getCurrentSession().createCriteria(DocRating.class).list();
    }
}
