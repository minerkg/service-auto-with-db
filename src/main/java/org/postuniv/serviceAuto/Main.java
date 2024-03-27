package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.repository.*;
import org.postuniv.serviceAuto.service.CarServiceService;
import org.postuniv.serviceAuto.ui.Console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarServiceRepository carServiceRepository = new CarServiceRepositoryImpl();
        ClientCardRepository clientCardRepository = new ClientCardRepositoryImpl();
        CarServiceService carServiceService = new CarServiceService(carServiceRepository, clientCardRepository);
        Console console = new Console(carServiceService);

        console.runMenu();

        // TODO: car service service not ok name,
        // TODO:clinet card rename
        //TODO: car service repo rename to carRepo
        //TODO: rename with Capital letter The Repository and service Class NAMES !
    }
}