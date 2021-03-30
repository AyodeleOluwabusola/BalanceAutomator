package com.audit.automator.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractBaseRepository {
    private static final Logger log = LoggerFactory.getLogger(AbstractBaseRepository.class);

    public AbstractBaseRepository() {
    }

    public abstract EntityManager getEntityManager();

    public void create(Object entity) {
        this.getEntityManager().persist(entity);
    }

    public void createBulk(Collection<?> entities) {
        if (entities != null) {
            Iterator var2 = entities.iterator();

            while (var2.hasNext()) {
                Object entity = var2.next();
                this.create(entity);
            }

        }
    }

    public void delete(Object entity) {
        this.getEntityManager().remove(entity);
    }

    public void deleteBulk(Collection<?> entities) {
        if (entities != null) {
            Iterator var2 = entities.iterator();

            while (var2.hasNext()) {
                Object entity = var2.next();
                this.delete(entity);
            }

        }
    }

    public <T> T update(T entity) {
        return this.getEntityManager().merge(entity);
    }

    public void updateBulk(Collection<?> entities) {
        if (entities != null) {
            Iterator var2 = entities.iterator();

            while (var2.hasNext()) {
                Object entity = var2.next();
                this.update(entity);
            }

        }
    }

    public <T> T findById(Class<T> entityClass, Object primaryKey) {
        return this.getEntityManager().find(entityClass, primaryKey);
    }

    public <T> T findById(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
        return this.getEntityManager().find(entityClass, primaryKey, lockMode);
    }

    public <T> T findById(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
        return this.getEntityManager().find(entityClass, primaryKey, properties);
    }

}
