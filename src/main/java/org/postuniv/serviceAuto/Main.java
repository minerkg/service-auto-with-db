package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.repository.*;
import org.postuniv.serviceAuto.service.CarService;
import org.postuniv.serviceAuto.service.ClientService;
import org.postuniv.serviceAuto.service.TransactionService;
import org.postuniv.serviceAuto.ui.Console;


public class Main {
    public static void main(String[] args) {
        CarServiceRepo<Car> carServiceRepository = new CarServiceRepoImpl<>();
        CarServiceRepo<ClientCard> clientCardRepository = new CarServiceRepoImpl<>();
        CarServiceRepo<Transaction> transactionsRepository = new CarServiceRepoImpl<>();
        CarService carService = new CarService(carServiceRepository);
        ClientService clientService = new ClientService(clientCardRepository);
        TransactionService transactionService = new TransactionService(transactionsRepository, clientService, carService);
        Console console = new Console(carService, clientService, transactionService);
        console.runMenu();


        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}