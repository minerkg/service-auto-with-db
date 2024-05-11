package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarServiceRepoPostgresSQL <T extends Entity> implements CarServiceRepo <T>{
    private final String DB_URL ="jdbc:postgresql://localhost:5432/";
    private final String DB_USER = System.getenv("");
    private final String DB_PASS = System.getenv("");

    Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

    public CarServiceRepoPostgresSQL() throws SQLException {
    }


    @Override
    public List<T> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table1");
        while (resultSet.next()) {
            resultSet.getString(1);
        }
        return null;

    }

    @Override
    public boolean save(T Entity) {
        return false;
    }

    @Override
    public boolean update(T Entity) {
        return false;
    }

    @Override
    public T findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int EntityId) {
        return false;
    }
}
