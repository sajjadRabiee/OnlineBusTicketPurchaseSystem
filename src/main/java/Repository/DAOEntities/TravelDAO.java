package Repository.DAOEntities;

import Repository.EntityManagerFactory.EMF;
import Service.Entities.Ticket;
import Service.Entities.Travel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TravelDAO extends BaseEntityDAO<Travel,Long> {
    @Override
    public void setEntityClass() {
        super.entityClass = Travel.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }

    public List<Travel> findTravelByProperty(String beginning , String destination , Date date) {
        List<Travel> travel;
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        try {
            transaction.begin();
            CriteriaQuery<Travel> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Travel> root = criteriaQuery.from(entityClass);
            List<Predicate> predicates = new ArrayList<Predicate>();
            predicates.add(criteriaBuilder.like(root.get("beginning"), beginning));
            predicates.add(criteriaBuilder.like(root.get("destination"), destination));
            predicates.add(criteriaBuilder.equal(root.get("dateOfMovement"), date));
            criteriaQuery.where(predicates.toArray(new Predicate[]{}));
            TypedQuery<Travel> entityTypedQuery = em.createQuery(criteriaQuery);
            travel = entityTypedQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
            travel = null;
        } finally {
            em.close();
        }
        return travel != null ? travel : new ArrayList<>();
    }
}
