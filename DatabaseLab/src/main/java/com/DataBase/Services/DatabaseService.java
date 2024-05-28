package com.DataBase.Services;

import com.DataBase.Repositories.SQLQueryRepository;
import com.FileReader.TXTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DatabaseService {

    @Autowired
    private SQLQueryRepository sqlQueryRepository;

    private final TXTReader txtReader = new TXTReader();

    public void reloadDatabase() {
        drop();
        create();
        initialInsert();
    }

    private void create() {
        String queries = txtReader.read("queries/createQueries.txt");
        if (!queries.trim().isEmpty()) {
            try {
                sqlQueryRepository.executeQuery(queries.trim());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void drop() {
        String queries = txtReader.read("queries/dropQueries.txt");
        if (!queries.trim().isEmpty()) {
            try {
                sqlQueryRepository.executeQuery(queries.trim());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void initialInsert() {
        String queries = txtReader.read("queries/insertQueries.txt");
        if (!queries.trim().isEmpty()) {
            try {
                sqlQueryRepository.executeQuery(queries.trim());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
