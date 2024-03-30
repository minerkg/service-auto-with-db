package org.postuniv.serviceAuto.ui;
import org.postuniv.serviceAuto.service.CarService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import org.postuniv.serviceAuto.domain.*;

public class Console {

    private final CarService carService;
    private MenuOptions menuOptions;

    public Console(CarService carService) {
        this.carService = carService;
    }



    private void showMenuItems () {
        System.out.println("\n*** Please select the operation witch you want to perform: ***");
        int optionNumber = 0;
        for (MenuOptions menuOption : MenuOptions.values()) {
            System.out.println(optionNumber + ". " + menuOption.getOptionName());
            optionNumber++;
        }
        System.out.println("***                                                        ***");
    }

    //Front-end object creation without back-end validations
    private Car createCar() {
        System.out.println("Please enter the ID of the car: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Please enter the model of the car: ");
        String model = new Scanner(System.in).next();
        System.out.println("Please the date of purchase of the car: ");
        LocalDate purchaseDate = LocalDate.parse(new Scanner(System.in).next());
        System.out.println("Please enter the mileage of the car: ");
        int km = new Scanner(System.in).nextInt();
        System.out.println("Please enter whether the car is under warranty or not (if so type true, otherwise false)");
        boolean warranty = Boolean.parseBoolean(new Scanner(System.in).next());

        return new Car(id,model,purchaseDate,km,warranty);
    }

    private ClientCard createClientCard() {
        System.out.println("Please enter the ID of the car: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Please enter first name of the card's owner:");
        String firstName = new Scanner(System.in).next();
        System.out.println("Please enter last name of the card's owner:");
        String lastName = new Scanner(System.in).next();
        System.out.println("Please enter the CNP of the card's owner:");
        String CNP = new Scanner(System.in).next();
        System.out.println("Please enter the date of birth of the card's owner: ");
        LocalDate birthDate = LocalDate.parse(new Scanner(System.in).next());
        //the registration date is automatically filled out
        LocalDate registrationDate = LocalDate.now();

        return new ClientCard(id, firstName, lastName, CNP, birthDate, registrationDate);
    }

    private Transaction createTransaction() {
        System.out.println("Please enter the ID of the transaction: ");
        long transactionId = new Scanner(System.in).nextLong();
        System.out.println("Please enter the ID of the car: ");
        int carId = new Scanner(System.in).nextInt();
        System.out.println("Please enter the ID of the Client Card: ");
        int clientCardId = new Scanner(System.in).nextInt();
        System.out.println("Please enter the price of the spare part: ");
        double partPrice = new Scanner(System.in).nextDouble();
        System.out.println("Please enter the cost of labour: ");
        double laborPrice = new Scanner(System.in).nextDouble();
        //the transaction time stamp is automatically filled out
        LocalDateTime transactionTimeStamp = LocalDateTime.now();

        return new Transaction(transactionId, carId, clientCardId, partPrice, laborPrice, transactionTimeStamp);
    }



    // Submenu for CRUD operations called in main menu
    private void runCrudMenu() {
        boolean menuIsRunning = true;
        CrudMenuOptions selectedOption;

        while (menuIsRunning) {
            // Entry selection
            System.out.println("Select which entry you want to manipulate: ");
            String[] entryList = new String[] {"Car", "ClientCard", "Transaction"};
            System.out.println(Arrays.toString(entryList));
            String selectedEntry = entryList[new Scanner(System.in).nextInt()];
            // End entry selection

            // Displaying the menu items
            System.out.println("\n*** Please select the operation which you want to perform: ***");
            int optionNumber = 0;
            for (CrudMenuOptions menuOption : CrudMenuOptions.values()) {
                System.out.println(optionNumber + ". " + menuOption.getOptionName());
                optionNumber++;
            }
            System.out.println("***                                                        ***");

            // the user selects which operation wants to perform
            selectedOption = CrudMenuOptions.values()[new Scanner(System.in).nextInt()];

            switch (selectedOption) {
                case BACK:
                    menuIsRunning = false;
                    break;
                case CREATE:
                    switch (selectedEntry) {
                        case "Car":
                            this.carService.addCar(createCar());
                            break;
                        case "ClientCard":
                            this.carService.addNewClientCard();
                            break;
                        case "Transaction":
                            this.carService.addNewTransaction();
                            break;
                    }
                case READ:
                    switch (selectedEntry) {
                        case "Car":
                            this.carService.getAllCars();
                            break;
                        case "ClientCard":
                            this.carService.getAllClientCards();
                            break;
                        case "Transaction":
                            this.carService.getAllTransactions();
                            break;
                    }
                case UPDATE:
                    switch (selectedEntry) {
                        case "Car":
                            this.carService.updateCar(idCar, updatedCar);
                            break;
                        case "ClientCard":
                            this.carService.updateClientCard(idClientCard, updatedClientCard);
                            break;
                        case "Transaction":
                            this.carService.updateTransaction(idTransaction, updatedTransaction);
                            break;
                    }
                case DELETE:
                    switch (selectedEntry) {
                        case "Car":
                            this.carService.removeCar(idCar);
                            break;
                        case "ClientCard":
                            this.carService.removeClientCard(idClientCard);
                            break;
                        case "Transaction":
                            this.carService.removeTransaction(idTransaction);
                            break;
                    }
            }
        }
    }


    public void runMenu() {
        boolean menuIsRunning = true;
        MenuOptions selectedOption;
        while (menuIsRunning) {
            showMenuItems();
            selectedOption = MenuOptions.values()[new Scanner(System.in).nextInt()];
            System.out.println("You selected: " + selectedOption.getOptionName());
            switch (selectedOption) {
                case EXIT:
                    menuIsRunning = false;
                    break;
                case CURD_OPTIONS:
                    runCrudMenu();
                    break;
                case SEARCH_CAR_AND_CLIENT_BY_NAME:
                    break;
                case SHOW_TRANSACTIONS_BETWEEN_TWO_DATES:
                    break;
                case SHOW_CARS_BY_REPARATION_COSTS:
                    break;
                case CLIENT_CARDS_BY_DISCOUNTS:
                    break;
                case DELETE_TRANSACTIONS_BETWEEN_TWO_DATES:
                    break;
                case UPDATE_CAR_WARRANTY_STATUSES:
                    break;
            }
        }
    }
}
