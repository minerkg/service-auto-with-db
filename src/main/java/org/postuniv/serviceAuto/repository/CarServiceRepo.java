package org.postuniv.serviceAuto.repository;

import java.sql.SQLException;
import java.util.List;

public interface CarServiceRepo <T> {
    List<T> findAll() throws SQLException;

    boolean save(T Entity);

    boolean update(T Entity);

    T findById(int id);

    boolean delete(int EntityId);
}
