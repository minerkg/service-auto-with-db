package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceRepositoryImpl implements CarServiceRepository {
    List<Car> carList;

    public CarServiceRepositoryImpl() {
        this.carList = new ArrayList<>();
    }

    @Override
    public List<Car> findAll() {
        return carList;
    }

    @Override
    public boolean save(Car car) {
        if (findById(car.getId()) != null) {
            throw new RuntimeException("Duplicate ID");
        } else {
            carList.add(car);
            return true;
        }
    }

    @Override
    public boolean update(Car car) {
        Car updateCar = findById(car.getId());
        if (updateCar == null) {
            throw new RuntimeException("Car not found");
        } else {

            updateCar.setModel(car.getModel());
            updateCar.setYearOfAquisition(car.getYearOfAquisition());
            updateCar.setKm(car.getKm());
            updateCar.setWarranty(car.getWarranty());
            return true;
        }
    }

    @Override
    public Car findById(int id) {
        for (Car car : carList) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Car car = findById(id);
        if (car == null) {
            throw new RuntimeException("Car not exist");
        }
        carList.remove(car);
        return true;

    }

}
