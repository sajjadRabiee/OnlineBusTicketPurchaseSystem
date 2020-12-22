package Repository.DAOEntities;

import Repository.EntityManagerFactory.EMF;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseEntityDAO<Entity, ID extends Number> {
    protected Class<Entity> entityClass;

    protected abstract void setEntityClass();

    protected String columnName;

    protected abstract void setColumnName(String columnName);

    //find
    //  byID
    public Optional<Entity> findByID(ID id) {
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        Entity entity;
        try {
            entity = em.find(entityClass, id);
        } catch (Exception e) {
            entity = null;
            System.out.println(e);
        } finally {
            em.close();
        }
        return entity != null ? Optional.of(entity) : Optional.ofNullable(null);
    }

    //  byName
    public Optional<Entity> findByName(String name) {
        Entity entity;
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        try {
            transaction.begin();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);
            criteriaQuery.where(criteriaBuilder.like(root.get(columnName), name));
            TypedQuery<Entity> entityTypedQuery = em.createQuery(criteriaQuery);
            entity = entityTypedQuery.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
            entity = null;
        } finally {
            em.close();
        }
        return entity != null ? Optional.of(entity) : Optional.ofNullable(null);
    }

    // all
    public List<Entity> findAll(){
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Entity> objects;
        try {
            transaction.begin();
            TypedQuery<Entity> query = em.createQuery("select e from "+entityClass.getName()+" e",entityClass);
            objects = query.getResultList();
            transaction.commit();
        }catch (Exception e){
            objects = new ArrayList<Entity>();
            transaction.rollback();
            System.out.println(e);
        }

        return objects;
    }
    //add
    public boolean add(Entity entity) {
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        boolean bool = false;
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
            bool = true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            bool = false;
        } finally {
            em.close();
        }
        return bool;
    }

    //update
    public boolean update(Entity entity) {
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        boolean bool = false;
        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
            bool = true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            bool = false;
        } finally {
            em.close();
        }
        return bool;
    }

    //delete
    public boolean delete(Entity entity) {
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        //Session session = em.unwrap(Session.class);
        EntityTransaction transaction = em.getTransaction();
        boolean bool = false;
        try {
            transaction.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            //session.delete();
            transaction.commit();
            bool = true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
            bool = false;
        } finally {
            em.close();
        }
        return bool;
    }
}

