package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.repository.TransactionsRepository;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionService {
    private final TransactionsRepository transactionsRepository;
    private final ClientService clientService;
    private final CarService carService;

    public TransactionService(TransactionsRepository transactionsRepository, ClientService clientService, CarService carService) {
        this.transactionsRepository = transactionsRepository;
        this.clientService = clientService;
        this.carService = carService;

    }

    public boolean addNewTransaction(Transaction transaction) {
        Car car = carService.getCarById(transaction.getCarId());
        ClientCard myClientCard = clientService.getClientCardById(transaction.getClientCardId());
        if (myClientCard == null) {
            if (car == null){

            }


            if (verifyTransactionParameter(transaction)) {
                transactionsRepository.addTransaction(transaction);
                return true;
            } else return false;
        } else {
            if (car.getWarranty()) {
                transaction.setPartPrice(0);
            }
            if (verifyTransactionParameter(transaction)) {
                transactionsRepository.addTransaction(transaction);
                return true;
            } else return false;  //TODO: de corelat cu client card repo.
        }
    }

    public List<Transaction> getAllTransactions() {
        return transactionsRepository.getAllTransactions();
    }

    public Transaction getTransactionById(long transactionId) {
        Transaction transaction = transactionsRepository.getTransactionById(transactionId);
        if (transaction == null) {
            throw new RuntimeException("Transaction not found"); //TODO: handle exception
        } else return transaction;
    }

    public List<Transaction> getTransactionsByClientId(long clientId) {
        List<Transaction> newTransactionList = transactionsRepository.getTransactionByClientId(clientId);
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

    public boolean removeTransactionById(long transactionID) {
        return transactionsRepository.removeTransaction(transactionID);
    }

    public boolean updateTransaction(long id, long carID, long clientCardId, double partPrice, double laborPrice, LocalDateTime localDateTime) {
        Transaction updatedTransaction = new Transaction(id, carID, clientCardId, partPrice, laborPrice, LocalDateTime.now());
        if (getTransactionById(id) == null) {
            throw new RuntimeException("Transaction not found");    //TODO: handle exception
        } else return transactionsRepository.updateTransaction(id, updatedTransaction);
    }

}
