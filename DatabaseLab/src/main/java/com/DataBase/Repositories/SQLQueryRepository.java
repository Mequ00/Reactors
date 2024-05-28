package com.DataBase.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

@Repository
public class SQLQueryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void executeQuery(String query) throws SQLException {
        entityManager.createNativeQuery(query).executeUpdate();
    }
}
