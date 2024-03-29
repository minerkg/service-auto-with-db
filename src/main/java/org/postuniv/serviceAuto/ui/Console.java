package org.postuniv.serviceAuto.ui;
import org.postuniv.serviceAuto.service.CarServiceService;

import java.util.Arrays;
import java.util.Scanner;
import org.postuniv.serviceAuto.domain.*;

public class Console {

    private final CarServiceService carServiceService;
    private MenuOptions menuOptions;

    public Console(CarServiceService carServiceService) {
        this.carServiceService = carServiceService;
    }

    private void showMenuItems () {
        System.out.println("\n*** Please select the operation which you want to perform: ***");
        int optionNumber = 0;
        for (MenuOptions menuOption : MenuOptions.values()) {
            System.out.println(optionNumber + ". " + menuOption.getOptionName());
            optionNumber++;
        }
        System.out.println("***                                                        ***");
    }

    private void runCrudMenu(String selectedEntry) {
        boolean menuIsRunning = true;
        CrudMenuOptions selectedOption;
        while (menuIsRunning) {
            System.out.println("\n*** Please select the operation which you want to perform: ***");
            int optionNumber = 0;
            for (CrudMenuOptions menuOption : CrudMenuOptions.values()) {
                System.out.println(optionNumber + ". " + menuOption.getOptionName());
                optionNumber++;
            }
            System.out.println("***                                                        ***");
            selectedOption = CrudMenuOptions.values()[new Scanner(System.in).nextInt()];
            switch (selectedOption) {
                case BACK:
                    menuIsRunning = false;
                    break;
                case CREATE:
                    switch (selectedEntry) {
                        case "Car":
                            this.carServiceService.addCar();
                            break;
                        case "ClientCard":
                            this.carServiceService.addNewClientCard();
                            break;
                        case "Transaction":
                            this.carServiceService.addNewTransaction();
                            break;
                    }
                case READ:
                    switch (selectedEntry) {
                        case "Car":
                            this.carServiceService.getAllCars();
                            break;
                        case "ClientCard":
                            this.carServiceService.getAllClientCards();
                            break;
                        case "Transaction":
                            this.carServiceService.getAllTransactions();
                            break;
                    }
                case UPDATE:
                    switch (selectedEntry) {
                        case "Car":
                            this.carServiceService.updateCar(idCar, updatedCar);
                            break;
                        case "ClientCard":
                            this.carServiceService.updateClientCard(idClientCard, updatedClientCard);
                            break;
                        case "Transaction":
                            this.carServiceService.updateTransaction(idTransaction, updatedTransaction);
                            break;
                    }
                case DELETE:
                    switch (selectedEntry) {
                        case "Car":
                            this.carServiceService.removeCar(idCar);
                            break;
                        case "ClientCard":
                            this.carServiceService.removeClientCard(idClientCard);
                            break;
                        case "Transaction":
                            this.carServiceService.removeTransaction(idTransaction);
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
                    String[] entryList = new String[] {"Car", "ClientCard", "Transaction"};
                    System.out.println(Arrays.toString(entryList));
                    String selectedEntry = entryList[new Scanner(System.in).nextInt()];
                    runCrudMenu(selectedEntry);
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
