package Repository.DAOEntities;

import Repository.EntityManagerFactory.EMF;
import Service.Entities.Ticket;
import Service.Entities.Travel;
import Service.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends BaseEntityDAO<Ticket,Long>{
    @Override
    public void setEntityClass() {
        super.entityClass = Ticket.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }

    public List<Ticket> findTicketesOfUser(User user){
        List<Ticket> tickets;
        EntityManager em = EMF.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        try {
            transaction.begin();
            CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Ticket> root = criteriaQuery.from(entityClass);
            List<Predicate> predicates = new ArrayList<Predicate>();
            predicates.add(criteriaBuilder.equal(root.get("user"), user));
            criteriaQuery.where(predicates.toArray(new Predicate[]{}));
            TypedQuery<Ticket> entityTypedQuery = em.createQuery(criteriaQuery);
            tickets = entityTypedQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
            tickets = null;
        } finally {
            em.close();
        }
        return tickets != null ? tickets : new ArrayList<>();
    }
}
