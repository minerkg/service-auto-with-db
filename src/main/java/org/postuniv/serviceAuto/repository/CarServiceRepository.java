package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;
import java.util.List;

public interface CarServiceRepository {
    List<Car> findAll();
    void save(Car car);
    void update(Car car);
    Car findById(int id);
    void delete(int carId);
}


