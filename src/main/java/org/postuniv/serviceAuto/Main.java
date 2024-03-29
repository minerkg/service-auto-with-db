package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.repository.CarServiceRepositoryImpl;
import org.postuniv.serviceAuto.service.CarServiceService;
import org.postuniv.serviceAuto.repository.*;
import org.postuniv.serviceAuto.ui.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CarServiceRepository carServiceRepository = new CarServiceRepositoryImpl();
        ClientCardRepository clientCardRepository = new ClientCardRepositoryImpl();
        TransactionsRepository transactionsRepository = new TransactionsRepositoryImpl();
        CarServiceService carServiceService = new CarServiceService(carServiceRepository, clientCardRepository, transactionsRepository);


        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}