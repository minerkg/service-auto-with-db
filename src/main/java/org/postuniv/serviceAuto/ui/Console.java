package org.postuniv.serviceAuto.ui;
import org.postuniv.serviceAuto.service.CarService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import org.postuniv.serviceAuto.domain.*;
import org.postuniv.serviceAuto.service.ClientService;
import org.postuniv.serviceAuto.service.TransactionService;

public class Console {

    private final CarService carService;
    private final ClientService clientService;
    private final TransactionService transactionService;
    private MenuOptions menuOptions;

    public Console(CarService carService, ClientService clientService, TransactionService transactionService) {
        this.clientService = clientService;
        this.carService = carService;
        this.transactionService = transactionService;
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
                            this.clientService.addNewClientCard(createClientCard());
                            break;
                        case "Transaction":
                            this.transactionService.addNewTransaction(createTransaction());
                            break;
                    }break;
                case READ:
                    switch (selectedEntry) {
                        case "Car":
                            System.out.println(this.carService.getAllCars());
                            break;
                        case "ClientCard":
                            System.out.println(this.clientService.getAllClientCards());
                            break;
                        case "Transaction":
                            System.out.println(this.transactionService.getAllTransactions());
                            break;
                    }break;
                case UPDATE:
                    switch (selectedEntry) {
                        case "Car":
                            Car updatedCar = createCar();
                            this.carService.updateCar(updatedCar);
                            break;
                        case "ClientCard":
                            ClientCard updatedClientCard = createClientCard();
                            this.clientService.updateClientCard(updatedClientCard);
                            break;
                        case "Transaction":
                            Transaction updatedTransaction = createTransaction();
                            this.transactionService.updateTransaction(updatedTransaction);
                            break;
                    }break;
                case DELETE:
                    switch (selectedEntry) {
                        case "Car":
                            System.out.println("Please enter the ID of the car which you want to delete:");
                            int idCar = new Scanner(System.in).nextInt();
                            this.carService.removeCar(idCar);
                            break;
                        case "ClientCard":
                            System.out.println("Please enter the ID of the card which you want to delete:");
                            int idClientCard = new Scanner(System.in).nextInt();
                            this.clientService.removeClientCard(idClientCard);
                            break;
                        case "Transaction":
                            System.out.println("Please enter the ID of the transaction which you want to delete:");
                            int idTransaction = new Scanner(System.in).nextInt();
                            this.transactionService.removeTransaction(idTransaction);
                            break;
                    }break;

            }
            System.out.println("Do you want to perform other CRUD operation ?");
            String selectedOption2 = new Scanner(System.in).next();
            menuIsRunning = selectedOption2.equals("yes");
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
