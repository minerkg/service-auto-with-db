package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.repository.CarServiceRepositoryImpl;
import org.postuniv.serviceAuto.service.CarService;
import org.postuniv.serviceAuto.repository.*;


public class Main {
    public static void main(String[] args) {
        CarServiceRepository carServiceRepository = new CarServiceRepositoryImpl();
        ClientCardRepository clientCardRepository = new ClientCardRepositoryImpl();
        TransactionsRepository transactionsRepository = new TransactionsRepositoryImpl();
        CarService carService = new CarService(carServiceRepository, clientCardRepository, transactionsRepository);


        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}