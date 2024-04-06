package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.repository.CarServiceRepo;
import org.postuniv.serviceAuto.repository.ReadTransactionFromFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
    private final CarServiceRepo<Transaction> transactionsRepository;
    private final ClientService clientService;
    private final CarService carService;

    public TransactionService(CarServiceRepo<Transaction> transactionsRepository, ClientService clientService, CarService carService) {
        this.transactionsRepository = transactionsRepository;
        this.clientService = clientService;
        this.carService = carService;
        ReadTransactionFromFile.readTransaction(this);


    }

    public List<Transaction> getTransactionByClientId(int clientId) {

        return transactionsRepository.findAll().stream().filter(trans -> trans.getClientCardId() == clientId).collect(Collectors.toList());
    }

    public boolean addNewTransaction(Transaction transaction) {
        if (applyDiscountsForTransaction(transaction)) {
            transactionsRepository.save(transaction);
            return true;
        } else return false;
    }

    public boolean applyDiscountsForTransaction(Transaction transaction) {
        Car car = carService.getCarById(transaction.getCarId());
        ClientCard myClientCard = clientService.getClientCardById(transaction.getClientCardId());
        double price = transaction.getLaborPrice();
        if (car == null) {
            return false;
        }
        if (myClientCard != null) {
            transaction.setLaborPrice(price - (transaction.getLaborPrice() * 10) / 100);
        }
        if (car.getWarranty()) {
            transaction.setPartPrice(0);
        }
        return true;

    }


    public List<Transaction> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    public Transaction getTransactionById(int transactionId) {
        Transaction transaction = transactionsRepository.findById(transactionId);
        if (transaction == null) {
            throw new RuntimeException("Transaction not found"); //TODO: handle exception
        } else return transaction;
    }

    public List<Transaction> getTransactionsByClientId(int clientId) {
        List<Transaction> newTransactionList = getTransactionByClientId(clientId);
        if (newTransactionList.isEmpty()) {
            return null;
        } else return newTransactionList;
    }

    public boolean verifyTransactionParameter(Transaction transaction) {
        if (
                transaction.getTransactionId() > 0 &&
                        transaction.getCarId() > 0 &&
                        transaction.getClientCardId() >= 0 &&
                        transaction.getPartPrice() >= 0 &&
                        transaction.getLaborPrice() > 0 &&
                        transaction.getTransactionStamp().isBefore(LocalDateTime.now())
        ) {
            return true;
        } else return false;
    }

    public boolean removeTransactionById(int transactionID) {
        return transactionsRepository.delete(transactionID);
    }

    public boolean updateTransaction(Transaction transaction) {

        if (getTransactionById((int) transaction.getTransactionId()) == null) {
            throw new RuntimeException("Transaction not found");    //TODO: handle exception
        } else {
            applyDiscountsForTransaction(transaction);
            return transactionsRepository.update(transaction);
        }
    }

    public boolean removeTransaction(int idTransaction) {
        return transactionsRepository.delete(idTransaction);
    }

    public List<Transaction> getTransactionByDate(LocalDateTime startingDate, LocalDateTime endingDate) {
        return getAllTransactions().
                stream().
                filter(
                        transaction -> transaction.getTransactionStamp().isAfter(startingDate) &&
                                transaction.getTransactionStamp().isBefore(endingDate)).
                collect(Collectors.toList());
    }

}
