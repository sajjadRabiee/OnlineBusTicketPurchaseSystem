package Repository.EntityManagerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static EntityManagerFactory entityManagerFactory;
    private EMF(){

    }
    public static EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory==null){
            entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        }
        return entityManagerFactory;
    }
}
