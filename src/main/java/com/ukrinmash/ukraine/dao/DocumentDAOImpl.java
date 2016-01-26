package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.Document;
import com.ukrinmash.ukraine.domain.DocumentSection;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DocumentDAOImpl implements DocumentDAO {

    @Autowired
    SessionFactory sessionFactory;

    public DocumentDAOImpl() {
    }

    @Override
    public Long createDocument(Document document) {
        sessionFactory.getCurrentSession().save(document);
        return document.getDocId();
    }

    @Override
    public void updateDocument(Document document) {
        sessionFactory.getCurrentSession().update(document);
    }

    @Override
    public void deleteDocument(Document document) {
        sessionFactory.getCurrentSession().delete(document);
    }


    @Override
    public Document readDocument(Long docId) {
        return (Document) sessionFactory.getCurrentSession().get(Document.class, docId);
    }

    @Override
    public List<Document> findAllDocuments() {
        return sessionFactory.getCurrentSession().createCriteria(Document.class).list();
    }

    @Override
    public List<Document> findBySection(DocumentSection section) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Document.class);
        criteria.add(Restrictions.eq("section", section));
        return (List<Document>) criteria.list();
    }
}
