package com.imho.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

    private static final ThreadLocal<EntityManager> ENTITY_THREAD_LOCAL = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        EntityManager entityManager = ENTITY_THREAD_LOCAL.get();

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = emf.createEntityManager();
            ENTITY_THREAD_LOCAL.set(entityManager);
        }

        return entityManager;
    }

    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static void commitTransaction() {
        if (getEntityManager().getTransaction().isActive()) {
            getEntityManager().getTransaction().commit();
        }
    }

    public static void rollbackTransaction() {
        if (getEntityManager().getTransaction().isActive()) {
            getEntityManager().getTransaction().rollback();
        }
    }
}

