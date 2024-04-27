package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.repository.CarServiceRepo;
import java.util.Comparator;
import java.util.List;

public class CarService {
    private final CarServiceRepo<Car> carRepo;


    public CarService(CarServiceRepo<Car> carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public boolean addCar(Car newCar) {

        if (verifyCarToBeNotNull(newCar)) {
            carRepo.save(newCar);
            return true;
        } else return false;
        //TODO: try catch the runtime exception
    }

    public Car getCarById(int id) {
        for (Car c : getAllCars()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean verifyCarToBeNotNull(Car carToBeVerify) {
        return carToBeVerify.getId() != 0 &&
                carToBeVerify.getModel() != null &&
                carToBeVerify.getYearOfAquisition() != null &&
                carToBeVerify.getKm() >= 0;
//                carToBeVerify.getWarranty() != Boolean.parseBoolean(null); primitive boolean type never can't be null
    }

    public List<Car> filterByKm(int fromKm, int toKm) {
        return getAllCars().stream().filter(car -> car.getKm() > fromKm && car.getKm() < toKm).toList();
    }

    //Throws
    public boolean removeCar(int idCar) {
        //TODO catch RuntimeException("Car not exist");
        return carRepo.delete(idCar);
    }

    public List<Car> sortListByAquisitionDate(){
        List<Car> carList = getAllCars();
        carList.sort(Comparator.comparing(Car::getYearOfAquisition));
        return carList;
    }


    public boolean updateCar(Car updatedCar) {
        return this.carRepo.update(updatedCar);

    }
}
