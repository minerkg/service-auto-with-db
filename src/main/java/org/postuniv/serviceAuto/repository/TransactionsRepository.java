package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsRepository {
    public boolean addTransaction(Transaction transaction);
    public Transaction getTransactionById(long transactionId);
    public List<Transaction>  getTransactionByClientId(int clientId);
    public List<Transaction> getTransactionByDate(LocalDateTime startingDate, LocalDateTime endingDate); //TODO: move to service.
    public List<Transaction>  getTransactionByCarId(int carId);
    public List<Transaction> getAllTransactions();
    public boolean removeTransaction(long transactionId);
    public boolean updateTransaction(long transactionId,Transaction newTransaction);

}
