package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.repository.CarServiceRepository;
import org.postuniv.serviceAuto.repository.ClientCardRepository;
import org.postuniv.serviceAuto.repository.TransactionsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CarServiceService {
    // ----------Car services ------------------------------------------------
    private final CarServiceRepository carRepo;
    private final ClientCardRepository clientCardRepository;
    private final TransactionsRepository transactionsRepository;

    public CarServiceService(CarServiceRepository carRepo, ClientCardRepository clientCardRepository, TransactionsRepository transactionsRepository) {
        this.carRepo = carRepo;
        this.clientCardRepository = clientCardRepository;
        this.transactionsRepository = transactionsRepository;
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public boolean addCar(int id, String model, LocalDate localDate, int km, boolean warranty) {
        Car newCar = new Car(id, model, localDate, km, warranty);
        if (verifyCarToBeNotNull(newCar)) {
            carRepo.save(newCar);
            return true;
        } else return false;
        //TODO: try catch the runtime exception
    }

    public Car getCarById(int id) {
        for (Car c : getAllCars()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean verifyCarToBeNotNull(Car carToBeVerify) {
        return carToBeVerify.getId() != 0 &&
                carToBeVerify.getModel() != null &&
                carToBeVerify.getYearOfAquisition() != null &&
                carToBeVerify.getKm() >= 0;
//                carToBeVerify.getWarranty() != Boolean.parseBoolean(null); primitive boolean type never can't be null
    }

    public List<Car> filterByKm(int fromKm, int toKm) {
        return getAllCars().stream().filter(car -> car.getKm() > fromKm && car.getKm() < toKm).toList();
    }

    //Throws
    public boolean removeCar(int idCar) {
        carRepo.delete(idCar);//TODO catch RuntimeException("Car not exist");
        return true;
    }


    // ----------Client Card services --------------------------------------------------

    // ---add
    // TODO: CNP must be unique, we have to check it here
    public boolean addNewClientCard(int id, String firstName, String lastName, String CNP, Date birthDate, LocalDate registrationDate) {
        // - implementation
        return true;
    }

    // ---delete
    // ---update
    // ---read one
    // full text search
    // ---read all


    // ----------Transaction services -------------------------------------------------

    public boolean addNewTransaction(long transactionId, Car car, ClientCard clientCard, double partPrice, double laborPrice, LocalDateTime transactionStamp) {
        ClientCard myClientCard = clientCardRepository.getClientCard(clientCard.getFirstName(), clientCard.getLastName());
        if (myClientCard == null) {
            Transaction transaction = new Transaction(transactionId, car.getId(), partPrice, laborPrice, transactionStamp);
            if (car.getWarranty()) {
                transaction.setPartPrice(0);
            }

            if (verifyTransactionParameter(transaction)) {
                transactionsRepository.addTransaction(transaction);
                return true;
            } else return false;
        } else {
            Transaction transaction = new Transaction(transactionId, car.getId(), clientCard.getId(), partPrice, laborPrice, transactionStamp);
            if (car.getWarranty()) {
                transaction.setPartPrice(0);
            }
            if (verifyTransactionParameter(transaction)) {
                transactionsRepository.addTransaction(transaction);
                return true;
            } else return false;  //TODO: de corelat cu client card repo.
        }
    }
    public List<Transaction> getAllTransactions(){
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

    public boolean removeTransactionById(long transactionID){
        return transactionsRepository.removeTransaction(transactionID);
    }
    public boolean updateTransaction(long id, long carID, long clientCardId, double partPrice, double laborPrice, LocalDateTime localDateTime){
        Transaction updatedTransaction = new Transaction(id,carID,clientCardId,partPrice,laborPrice,LocalDateTime.now());
        if (getTransactionById(id) == null){
            throw new RuntimeException("Transaction not found");    //TODO: handle exception
        }else return transactionsRepository.updateTransaction(id,updatedTransaction);
    }



}
