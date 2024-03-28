package org.postuniv.serviceAuto;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.repository.ReadCarFromFile;
import org.postuniv.serviceAuto.repository.CarServiceRepositoryImpl;
import org.postuniv.serviceAuto.repository.TransactionsRepository;
import org.postuniv.serviceAuto.repository.TransactionsRepositoryImpl;
import org.postuniv.serviceAuto.service.CarServiceService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long epochLong = 725419815000L;
        LocalDateTime timePurchase = java.time.LocalDateTime.of(1991, 12, 27, 3, 27, 15);
        ZoneId zoneId = ZoneId.of("Europe/Bucharest");
        LocalDateTime epochDateTime = Instant.ofEpochMilli(epochLong).atZone(zoneId).toLocalDateTime();
        Transaction transaction = new Transaction(1,10,32,500.99,700,epochDateTime);
        Transaction transaction2 = new Transaction(2,25,56,500.99,700,epochDateTime);
        Transaction transaction3 = new Transaction(3,12,56,500.99,700,epochDateTime);
        Transaction transaction4 = new Transaction(4,10,32,500.99,700,epochDateTime);
        Transaction transaction5 = new Transaction(5,98,500.99,700,epochDateTime);

        TransactionsRepositoryImpl repo = new TransactionsRepositoryImpl();
        repo.addTransaction(transaction);
        repo.addTransaction(transaction2);
        repo.addTransaction(transaction3);
        repo.addTransaction(transaction4);
        repo.addTransaction(transaction5);

        repo.getTransactionByCarId(98).forEach(System.out::println);


        // TODO: car service service not ok name,
        //TODO: car service repo rename to carRepo

    }
}