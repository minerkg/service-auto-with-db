package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.repository.CarServiceRepository;

import org.postuniv.serviceAuto.repository.ClientCardRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CarServiceService {
    private final CarServiceRepository carRepo;
    private final ClientCardRepository clientCardRepository;

    public CarServiceService(CarServiceRepository carRepo, ClientCardRepository clientCardRepository) {
        this.carRepo = carRepo;
        this.clientCardRepository = clientCardRepository;
    }

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }
    public boolean addCar(int id, String model, LocalDate localDate, int km, boolean warranty){
        Car newCar = new Car(id,model,localDate,km,warranty);
        if (verifyCarToBeNotNull(newCar)){
            carRepo.save(newCar);
            return true;
        }
        else return false;
        //TODO: try catch the runtime exception
    }
    public boolean verifyCarToBeNotNull(Car carToBeVerify){
        return carToBeVerify.getId() != 0 &&
                carToBeVerify.getModel() != null &&
                carToBeVerify.getYearOfAquisition() != null &&
                carToBeVerify.getKm() >= 0;
//                carToBeVerify.getWarranty() != Boolean.parseBoolean(null); primitive boolean type never can't be null
    }
    public List<Car> filterByKm(int fromKm, int toKm){
        return getAllCars().stream().filter(car -> car.getKm()>fromKm && car.getKm()<toKm).toList();
    }
    //Throws
    public boolean removeCar(int idCar ){
        carRepo.delete(idCar);//TODO catch RuntimeException("Car not exist");
        return true;
    }



    // ----------Client Card services --------------






}
