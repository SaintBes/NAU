package com.ukrinmash.ukraine.dao;

import com.ukrinmash.ukraine.domain.VotesCache;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admssa on 14.12.2015.
 */

@Repository
public class VotesCacheDAOImpl implements VotesCacheDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long createVoteCache(VotesCache votesCache) {
        sessionFactory.getCurrentSession().save(votesCache);
        return votesCache.getVoteId();
    }

    @Override
    public void updateVoteCache(VotesCache votesCache) {
        sessionFactory.getCurrentSession().update(votesCache);
    }

    @Override
    public void deleteVoteCache(VotesCache votesCache) {
        sessionFactory.getCurrentSession().delete(votesCache);
    }

    @Override
    public VotesCache readVoteCache(Long voteCacheId) {
        return (VotesCache) sessionFactory.getCurrentSession().get(VotesCache.class,voteCacheId);
    }

    @Override
    public List<VotesCache> findAllVotesCache() {
        return (List<VotesCache>) sessionFactory.getCurrentSession().createCriteria(VotesCache.class).list();
    }

    @Override
    public List<VotesCache> findVotesCacheByRatingId(Long docRatingId) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VotesCache.class);
        criteria.add(Restrictions.eq("docRatingId", docRatingId));
        return  (List<VotesCache>) criteria.list();
    }
}
