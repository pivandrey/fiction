package library.fiction.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    private Class<T> clazz;

    protected GenericDAOImpl(Class <T> clazz) {
        this.clazz = clazz;
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(T obj) {
        Session session =  sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (HibernateException err) {
            if (tx != null) {
                tx.rollback();
            }
            err.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T obj) {
        Session session =  sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.clear();
            session.update(obj);
            session.flush();
            tx.commit();
        } catch (HibernateException err) {
            if (tx != null) {
                tx.rollback();
            }
            err.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(T obj) {
        Session session =  sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException err) {
            if (tx != null) {
                tx.rollback();
            }
            err.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public T findById(long id) {
        Session session =  sessionFactory.openSession();
        Transaction tx = null;
        T entity;
        try {
            tx = session.beginTransaction();
            entity = session.get(clazz, id);
            tx.commit();
        } catch (HibernateException err) {
            if (tx != null) {
                tx.rollback();
            }
            entity = null;
            err.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll(String query) {
        Session session =  sessionFactory.openSession();
        Transaction tx = null;
        List<T> entities = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            entities = session.createQuery(query).list();
            tx.commit();
        } catch (HibernateException err) {
            if (tx != null) {
                tx.rollback();
            }
            err.printStackTrace();
        } finally {
            session.close();
        }
        return entities;
    }
}
