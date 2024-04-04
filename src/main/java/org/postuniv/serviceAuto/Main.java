package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.repository.*;
import org.postuniv.serviceAuto.service.CarService;
import org.postuniv.serviceAuto.service.ClientService;
import org.postuniv.serviceAuto.service.TransactionService;
import org.postuniv.serviceAuto.ui.Console;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        CarServiceRepository carServiceRepository = new CarServiceRepositoryImpl();
        ClientCardRepository clientCardRepository = new ClientCardRepositoryImpl();
        TransactionsRepository transactionsRepository = new TransactionsRepositoryImpl();
        CarService carService = new CarService(carServiceRepository);
        ClientService clientService = new ClientService(clientCardRepository);
        TransactionService transactionService = new TransactionService(transactionsRepository, clientService, carService);
        Console console = new Console(carService, clientService, transactionService);
        console.runMenu();


        // Transaction ID [1] car_id [36] client_card_id [0] part_price [700.56] labor_price [429.0] time [2022-11-05T12:34:23]
        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}