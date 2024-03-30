package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;

import java.util.List;

public interface CarServiceRepository {
    List<Car> findAll();

    boolean save(Car car);

    boolean update(Car car);

    Car findById(int id);

    boolean delete(int carId);
}


