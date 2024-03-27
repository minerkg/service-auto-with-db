package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;
import java.util.ArrayList;
import java.util.Comparator;
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
    public void save(Car car) {
        if (findById(car.getId()) != null) {
            throw new RuntimeException("Duplicate ID");
        }
        carList.add(car);
    }

    @Override
    public void update(Car car) {
    Car updateCar = findById(car.getId());
    if (updateCar == null){
        throw new RuntimeException("Car not found");
    }
    updateCar.setModel(car.getModel());
    updateCar.setYearOfAquisition(car.getYearOfAquisition());
    updateCar.setKm(car.getKm());
    updateCar.setWarranty(car.getWarranty());
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
    public void delete(int id) {
        if (findById(id) == null){
            throw new RuntimeException("Car not exist");
        }
        carList.remove(findById(id));
//        for (Car carToBeRemove : carList) {
//            if (carToBeRemove.equals(car)){
//                carList.remove(carToBeRemove);
//                break;
//            }
//        }
    }
    public void sortListByAquisitionDate(){
        carList.sort(Comparator.comparing(Car::getYearOfAquisition));
    }
}
