package org.postuniv.serviceAuto.repository;

import java.util.ArrayList;
import java.util.List;

public class CarServiceRepoImpl <T> implements CarServiceRepo <T> {

    private List<T> entityList;

    public CarServiceRepoImpl() {
        this.entityList = new ArrayList<>();
    }

    @Override
    public List<T> findAll() {
        return entityList.stream().toList();
    }

    @Override
    public boolean save(T entity) {
        return entityList.add(entity);
    }

    @Override
    public boolean update(T entity) {
        return entityList.id;
    }

    @Override
    public T findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int entityId) {
        return false;
    }
}
