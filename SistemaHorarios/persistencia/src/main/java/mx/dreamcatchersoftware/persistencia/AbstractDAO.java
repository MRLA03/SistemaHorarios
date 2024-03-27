/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.persistencia;

/**
 *
 * @author saitbc
 */
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import mx.desarrollo.persistencia.InterfaceDAO;
import java.util.List;
//import mx.avanti.siract.dao.InterfaceDAO;
import org.hibernate.SQLQuery;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.Transformers;

/**
 * Generic abstract class avoid to extends another DAO for make generic methods
 * with the other DAO
 *
 * @param <PK>
 * @param <T>
 */
public abstract class AbstractDAO<PK extends Serializable, T> implements InterfaceDAO<T> {

    //private Session session;
    //private Transaction tx;
    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractDAO() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        //HibernateFactory.buildIfNeeded();
    }

    @Override
    public void save(T obj) {
        System.out.println("Save ----------");
        try {
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            HibernateUtil.getSession().save(obj);

        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }
  
}
