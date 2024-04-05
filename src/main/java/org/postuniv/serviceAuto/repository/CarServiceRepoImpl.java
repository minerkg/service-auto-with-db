package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Entity;

import java.util.ArrayList;
import java.util.List;

public class CarServiceRepoImpl <T extends Entity> implements CarServiceRepo <T> {

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
        entityList = entityList.stream().
                map(ent -> ent.getId() == entity.getId() ? ent = entity : ent).
                toList();
        return true; /// TODO: isn't solved yet
    }

    @Override
    public T findById(int id) {
        for (T entry: entityList) {
            if (entry.getId() == id) return entry;
        }
        return null;
    }

    @Override
    public boolean delete(int entityId) {
        return this.entityList.
                removeIf(entr -> entr.getId() == entityId);
    }
}
