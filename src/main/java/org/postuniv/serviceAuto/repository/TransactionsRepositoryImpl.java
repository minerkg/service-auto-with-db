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
    public Transaction getTransactionById(long transaction_id) {
      for (Transaction tr : transactions){
          if (tr.getTransactionId() == transaction_id){
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
    public List<Transaction> getTransactionByClientId(int client_id) {

        return transactions.stream().filter(trans -> trans.getClient_card_id() == client_id).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getTransactionByDate(LocalDateTime startingDate, LocalDateTime endingDate) {
        return transactions.
                stream().
                filter(
                        transaction -> transaction.getTransaction_stamp().isAfter(startingDate) &&
                                       transaction.getTransaction_stamp().isBefore(endingDate)).
                collect(Collectors.toList());   //TODO: move to service.
    }

    @Override
    public List<Transaction> getTransactionByCarId(int carId) {
        return transactions.stream().filter(trans -> trans.getCar_id() == carId).collect(Collectors.toList());
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
            transactionFound.setCar_id(newTransaction.getCar_id());
            transactionFound.setClient_card_id(newTransaction.getClient_card_id());
            transactionFound.setPart_price(newTransaction.getPart_price());
            transactionFound.setLabor_price(newTransaction.getLabor_price());
            return true;
        }
    }
}
