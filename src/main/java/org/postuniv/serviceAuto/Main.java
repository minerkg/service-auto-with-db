package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.repository.CarServiceRepositoryImpl;
import org.postuniv.serviceAuto.service.CarServiceService;
import org.postuniv.serviceAuto.repository.*;
import org.postuniv.serviceAuto.ui.Console;



public class Main {
    public static void main(String[] args) {
        CarServiceRepository carServiceRepository = new CarServiceRepositoryImpl();
        ClientCardRepository clientCardRepository = new ClientCardRepositoryImpl();
        CarServiceService carServiceService = new CarServiceService(carServiceRepository, clientCardRepository);
        Console console = new Console(carServiceService);

        console.runMenu();




        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}