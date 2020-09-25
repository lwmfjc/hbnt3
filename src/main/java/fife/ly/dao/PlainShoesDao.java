package fife.ly.dao;

import fife.ly.entity.Shoes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Repository
public class PlainShoesDao implements ShoesDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Shoes> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select s from Shoes s ",Shoes.class).list();
    }
}
