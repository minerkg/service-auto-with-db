package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsRepositoryImpl implements TransactionsRepository {
    List<Transaction> transactions;

    public TransactionsRepositoryImpl() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public Transaction getTransactionById(long transactionId) {
      for (Transaction tr : transactions){
          if (tr.getTransactionId() == transactionId){
              return tr;
          }
      }
      return null;
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        if (getTransactionById(transaction.getTransactionId()) == null) {
            transactions.add(transaction);
            return true;
        }
        return false;
    }

    @Override
    public List<Transaction> getTransactionByClientId(long clientId) {

        return transactions.stream().filter(trans -> trans.getClientCardId() == clientId).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getTransactionByDate(LocalDateTime startingDate, LocalDateTime endingDate) {
        return transactions.
                stream().
                filter(
                        transaction -> transaction.getTransactionStamp().isAfter(startingDate) &&
                                       transaction.getTransactionStamp().isBefore(endingDate)).
                collect(Collectors.toList());   //TODO: move to service.
    }

    @Override
    public List<Transaction> getTransactionByCarId(long carId) {
        return transactions.stream().filter(trans -> trans.getCarId() == carId).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public boolean removeTransaction(long transactionId) {
        Transaction trans = getTransactionById(transactionId);
        if (trans == null){
            return false;
        }else {
            transactions.remove(trans);
            return true;
        }
    }

    @Override
    public boolean updateTransaction(long transactionId, Transaction newTransaction) {
        Transaction transactionFound = getTransactionById(transactionId);
        if (transactionFound == null){
            return false;
        }else {
            transactionFound.setCarId(newTransaction.getCarId());
            transactionFound.setClientCardId(newTransaction.getClientCardId());
            transactionFound.setPartPrice(newTransaction.getPartPrice());
            transactionFound.setLaborPrice(newTransaction.getLaborPrice());
            return true;
        }
    }
}
