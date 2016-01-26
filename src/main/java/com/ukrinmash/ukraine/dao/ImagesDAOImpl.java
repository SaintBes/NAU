package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.Document;
import com.ukrinmash.ukraine.domain.Images;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImagesDAOImpl implements ImagesDAO {

    @Autowired
    SessionFactory sessionFactory;

    public ImagesDAOImpl() {
    }

    @Override
    public Long createImages(Images image) {
        sessionFactory.getCurrentSession().save(image);
        return image.getId();
    }

    @Override
    public void updateImages(Images image) {
        sessionFactory.getCurrentSession().update(image);
    }

    @Override
    public void deleteImages(Images image) {
        sessionFactory.getCurrentSession().delete(image);
    }

    @Override
    public Images readImages(Long imageId) {
        return (Images) sessionFactory.getCurrentSession().get(Images.class, imageId);
    }

    @Override
    public List<Images> findAiiByDocId(Document document) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Images.class);
        criteria.add(Restrictions.eq("document", document));
        return (List<Images>) criteria.list();
    }

    @Override
    public List<Images> findAllImages() {
        return sessionFactory.getCurrentSession().createCriteria(Images.class).list();
    }
}
