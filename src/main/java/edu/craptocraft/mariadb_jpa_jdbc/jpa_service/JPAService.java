package edu.craptocraft.mariadb_jpa_jdbc.jpa_service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
 
import java.util.function.Function;
 
public class JPAService {
 
    private static JPAService instance;
    private EntityManagerFactory entityManagerFactory;
 
    private JPAService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mariadb-jpa-jdbc");
    }
 
    public static synchronized JPAService getInstance() {
        return instance == null ? instance = new JPAService() : instance;
    }
 
    public void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            instance = null;
        }
    }
 
    public <T> T runInTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        boolean success = false;
        try {
            T returnValue = function.apply(entityManager);
            success = true;
            return returnValue;
 
        } finally {
            if (success) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
        }
    }
}
