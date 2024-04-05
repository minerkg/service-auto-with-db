package org.postuniv.serviceAuto.repository;

import java.util.List;

public interface CarServiceRepo <T> {
    List<T> findAll();

    boolean save(T Entity);

    boolean update(T Entity);

    T findById(int id);

    boolean delete(int EntityId);
}
