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


        // Transaction ID [1] car_id [36] client_card_id [0] part_price [700.56] labor_price [429.0] time [2022-11-05T12:34:23]
        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo
        //172 car has warranty   trans id 3 :
        // Transaction ID [3] car_id [172] client_card_id [22] part_price [0] labor_price [865.8] time [2023-05-28T00:46:23]
    }
}