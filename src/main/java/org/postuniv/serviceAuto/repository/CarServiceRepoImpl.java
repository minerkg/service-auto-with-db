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
