package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.repository.*;
import org.postuniv.serviceAuto.service.CarService;
import org.postuniv.serviceAuto.service.ClientService;
import org.postuniv.serviceAuto.service.TransactionService;
import org.postuniv.serviceAuto.ui.Console;


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


        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}